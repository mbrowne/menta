/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.common.lower

import org.jetbrains.kotlin.backend.common.FileLoweringPass
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.descriptors.Modality
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.ir.builders.declarations.addConstructor
import org.jetbrains.kotlin.ir.builders.declarations.addFunction
import org.jetbrains.kotlin.ir.builders.declarations.addValueParameter
import org.jetbrains.kotlin.ir.builders.declarations.buildClass
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrFactory
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.declarations.IrProperty
import org.jetbrains.kotlin.ir.declarations.IrValueParameter
import org.jetbrains.kotlin.ir.expressions.IrStatementOrigin
import org.jetbrains.kotlin.ir.declarations.IrFunction
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.declarations.createEmptyExternalPackageFragment
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.expressions.IrGetValue
import org.jetbrains.kotlin.ir.expressions.IrBlockBody
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.expressions.impl.IrCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrConstImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrConstructorCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrDelegatingConstructorCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrVarargImpl
import org.jetbrains.kotlin.ir.symbols.IrClassSymbol
import org.jetbrains.kotlin.ir.symbols.IrConstructorSymbol
import org.jetbrains.kotlin.ir.symbols.IrSimpleFunctionSymbol
import org.jetbrains.kotlin.ir.IrBuiltIns
import org.jetbrains.kotlin.ir.UNDEFINED_OFFSET
import org.jetbrains.kotlin.ir.types.IrDynamicType
import org.jetbrains.kotlin.ir.types.classOrNull
import org.jetbrains.kotlin.ir.types.defaultType
import org.jetbrains.kotlin.ir.types.typeWith
import org.jetbrains.kotlin.ir.util.constructors
import org.jetbrains.kotlin.ir.util.createThisReceiverParameter
import org.jetbrains.kotlin.ir.util.functions
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid
import org.jetbrains.kotlin.name.FqName

private val TRY_MEMBER_NAMES = setOf("tryInvokeMember", "tryGetMember", "trySetMember")

/**
 * Symbols for the `menta.dynamic.DynamicObject` runtime classes.
 * These are synthetic IR declarations that match the real runtime classes
 * in the stdlib's `menta.dynamic` package.
 */
class MentaDynamicSymbols(
    private val irFactory: IrFactory,
    private val irBuiltIns: IrBuiltIns,
    moduleDescriptor: ModuleDescriptor,
) {
    private val mentaDynamicPackage = createEmptyExternalPackageFragment(moduleDescriptor, FqName("menta.dynamic"))

    private fun createClass(
        fqName: FqName,
        classModality: Modality = Modality.FINAL,
        block: (org.jetbrains.kotlin.ir.declarations.IrClass) -> Unit = {},
    ): IrClassSymbol =
        irFactory.buildClass {
            name = fqName.shortName()
            kind = ClassKind.CLASS
            modality = classModality
        }.apply {
            parent = mentaDynamicPackage
            createThisReceiverParameter()
            block(this)
        }.symbol

    val getMemberBinderClass: IrClassSymbol = createClass(FqName("menta.dynamic.GetMemberBinder")) { klass ->
        klass.addConstructor().apply {
            addValueParameter("name", irBuiltIns.stringType)
        }
    }

    val setMemberBinderClass: IrClassSymbol = createClass(FqName("menta.dynamic.SetMemberBinder")) { klass ->
        klass.addConstructor().apply {
            addValueParameter("name", irBuiltIns.stringType)
        }
    }

    val invokeMemberBinderClass: IrClassSymbol = createClass(FqName("menta.dynamic.InvokeMemberBinder")) { klass ->
        klass.addConstructor().apply {
            addValueParameter("name", irBuiltIns.stringType)
            addValueParameter("args", irBuiltIns.arrayClass.defaultType)
        }
    }

    val dynamicObjectClass: IrClassSymbol = createClass(
        FqName("menta.dynamic.DynamicObject"),
        classModality = Modality.ABSTRACT,
    ) { klass ->
        klass.addConstructor() // no-args default constructor for delegating super calls
        klass.addFunction("tryGetMember", irBuiltIns.anyNType).apply {
            addValueParameter("binder", getMemberBinderClass.defaultType)
        }
        klass.addFunction("trySetMember", irBuiltIns.booleanType).apply {
            addValueParameter("binder", setMemberBinderClass.defaultType)
            addValueParameter("value", irBuiltIns.anyNType)
        }
        klass.addFunction("tryInvokeMember", irBuiltIns.anyNType).apply {
            addValueParameter("binder", invokeMemberBinderClass.defaultType)
        }
    }

    val tryGetMember: IrSimpleFunctionSymbol =
        dynamicObjectClass.functions.single { it.owner.name.asString() == "tryGetMember" }
    val trySetMember: IrSimpleFunctionSymbol =
        dynamicObjectClass.functions.single { it.owner.name.asString() == "trySetMember" }
    val tryInvokeMember: IrSimpleFunctionSymbol =
        dynamicObjectClass.functions.single { it.owner.name.asString() == "tryInvokeMember" }

    val getMemberBinderConstructor: IrConstructorSymbol = getMemberBinderClass.constructors.single()
    val setMemberBinderConstructor: IrConstructorSymbol = setMemberBinderClass.constructors.single()
    val invokeMemberBinderConstructor: IrConstructorSymbol = invokeMemberBinderClass.constructors.single()
    val dynamicObjectConstructor: IrConstructorSymbol = dynamicObjectClass.constructors.single()
}

/**
 * Transforms [IrDynamicMemberExpression] and [IrDynamicOperatorExpression] nodes
 * from Menta `define dynamic` classes into calls to `tryGetMember`, `trySetMember`,
 * and `tryInvokeMember` on `menta.dynamic.DynamicObject`.
 *
 * This lowering distinguishes Menta dynamic from Kotlin/JS dynamic by checking the
 * receiver type: Kotlin/JS dynamic uses [IrDynamicType], while Menta dynamic uses
 * a concrete class type that extends `DynamicObject`.
 */
class MentaDynamicCallLowering(
    private val irBuiltIns: IrBuiltIns,
    private val symbols: MentaDynamicSymbols,
) : FileLoweringPass, IrElementTransformerVoid() {
    
    private var currentClass: IrClass? = null

    override fun lower(irFile: IrFile) {
        irFile.transformChildrenVoid(this)
    }

    override fun visitClass(declaration: IrClass): IrStatement {
        val oldClass = currentClass
        currentClass = declaration
        try {
            declaration.transformChildrenVoid(this)
            // Ensure define-dynamic classes (those declaring try* methods) have DynamicObject as first supertype
            // so JVM codegen uses it as superclass and runtime casts succeed.
            if (isDefineDynamicClass(declaration)) {
                val dynamicObjType = symbols.dynamicObjectClass.defaultType
                val rest = declaration.superTypes.filter { it.classOrNull != symbols.dynamicObjectClass }
                declaration.superTypes = listOf(dynamicObjType) + rest
                patchSuperConstructorCalls(declaration)
            }
            return declaration
        } finally {
            currentClass = oldClass
        }
    }

    /**
     * Patches the delegating constructor calls in [irClass]'s constructors to call
     * `DynamicObject.<init>()` instead of `kotlin.Any.<init>()`.
     *
     * Without this patch, the JVM verifier rejects the bytecode because the class
     * declares `extends DynamicObject` in the class file but the constructor calls
     * `java/lang/Object.<init>` (the JVM mapping of `kotlin.Any`).
     *
     * We unconditionally replace any non-DynamicObject delegating super call, rather than
     * checking `isAny()`, because FIR may resolve the delegated super call to `kotlin.Any`
     * even when `delegatedSuperTypeRef = DynamicObject` was set in the raw FIR builder.
     * We also handle the case where FIR emits `IrErrorCallExpression` when the DynamicObject
     * constructor reference could not be resolved during FIR-to-IR conversion.
     */
    private fun patchSuperConstructorCalls(irClass: IrClass) {
        for (constructor in irClass.constructors) {
            val body = constructor.body as? IrBlockBody ?: continue
            val idx = body.statements.indexOfFirst { it is IrDelegatingConstructorCall }
            if (idx >= 0) {
                val oldCall = body.statements[idx] as IrDelegatingConstructorCall
                // Only replace if not already targeting DynamicObject (avoid unnecessary churn)
                if (oldCall.symbol != symbols.dynamicObjectConstructor) {
                    body.statements[idx] = IrDelegatingConstructorCallImpl(
                        oldCall.startOffset, oldCall.endOffset,
                        irBuiltIns.unitType,
                        symbols.dynamicObjectConstructor,
                        typeArgumentsCount = 0,
                    )
                }
            } else {
                // No IrDelegatingConstructorCall found — FIR may have emitted IrErrorCallExpression
                // when it couldn't resolve the DynamicObject constructor symbol. Replace or insert.
                val errIdx = body.statements.indexOfFirst { it is IrErrorCallExpression }
                val superCall = IrDelegatingConstructorCallImpl(
                    if (errIdx >= 0) (body.statements[errIdx] as IrErrorCallExpression).startOffset else UNDEFINED_OFFSET,
                    if (errIdx >= 0) (body.statements[errIdx] as IrErrorCallExpression).endOffset else UNDEFINED_OFFSET,
                    irBuiltIns.unitType,
                    symbols.dynamicObjectConstructor,
                    typeArgumentsCount = 0,
                )
                if (errIdx >= 0) {
                    body.statements[errIdx] = superCall
                } else {
                    body.statements.add(0, superCall)
                }
            }
        }
    }

    private fun isDefineDynamicClass(irClass: IrClass): Boolean =
        irClass.declarations.any { decl ->
            decl is IrFunction && decl.name.asString() in TRY_MEMBER_NAMES
        }

    private fun hasFunction(irClass: IrClass, name: String): Boolean =
        irClass.declarations.any { it is IrFunction && it.name.asString() == name }

    override fun visitDynamicOperatorExpression(expression: IrDynamicOperatorExpression): IrExpression {
        val memberReceiver = expression.receiver as? IrDynamicMemberExpression

        if (memberReceiver != null && expression.operator == IrDynamicOperator.INVOKE) {
            val receiverClass = memberReceiver.receiver.type.classOrNull?.owner
            if (receiverClass != null) {
                // Check if this invoke calls a defined method in the receiver class
                val method = receiverClass.declarations.find { decl ->
                    decl is IrSimpleFunction && decl.name.asString() == memberReceiver.memberName
                } as? IrSimpleFunction
                
                if (method != null) {
                    // Found a real method - call it directly instead of going through dynamic dispatch
                    val transformedInnerReceiver = memberReceiver.receiver.transform(this, null)
                    val transformedArgs = expression.arguments.map { it.transform(this, null) }
                    return IrCallImpl(
                        expression.startOffset, expression.endOffset,
                        method.returnType,
                        method.symbol,
                        typeArgumentsCount = 0,
                    ).apply {
                        dispatchReceiver = transformedInnerReceiver
                        for ((i, arg) in transformedArgs.withIndex()) {
                            arguments[i] = arg
                        }
                    }
                }
            }
        }

        // For truly undefined members or non-INVOKE operations, apply dynamic transformation
        if (memberReceiver != null && isMentaDynamic(memberReceiver)) {
            when (expression.operator) {
                IrDynamicOperator.INVOKE -> {
                    val transformedInnerReceiver = memberReceiver.receiver.transform(this, null)
                    val transformedArgs = expression.arguments.map { it.transform(this, null) }
                    return buildInvokeCall(expression, memberReceiver.memberName, transformedInnerReceiver, transformedArgs)
                }
                IrDynamicOperator.EQ -> {
                    val transformedInnerReceiver = memberReceiver.receiver.transform(this, null)
                    val transformedValue = expression.arguments.first().transform(this, null)
                    return buildSetCall(expression, memberReceiver.memberName, transformedInnerReceiver, transformedValue)
                }
                else -> {}
            }
        }

        expression.transformChildrenVoid(this)
        return expression
    }

    override fun visitDynamicMemberExpression(expression: IrDynamicMemberExpression): IrExpression {
        expression.transformChildrenVoid(this)

        val receiverClass = expression.receiver.type.classOrNull?.owner
        if (receiverClass != null) {
            // Check if the member is actually defined in the receiver class
            val property = receiverClass.declarations.find { decl ->
                decl is IrProperty && decl.name.asString() == expression.memberName
            } as? IrProperty
            
            if (property != null && property.getter != null) {
                // Return a call to the getter instead of dynamic access
                return IrCallImpl(
                    expression.startOffset, expression.endOffset,
                    property.getter!!.returnType,
                    property.getter!!.symbol,
                    typeArgumentsCount = 0,
                ).apply {
                    dispatchReceiver = expression.receiver
                }
            }
        }

        if (isMentaDynamic(expression)) {
            return transformDynamicGet(expression)
        }

        return expression
    }

    /**
     * Kotlin/JS dynamic uses [IrDynamicType] as the receiver type,
     * while Menta dynamic uses a concrete class type extending `DynamicObject`.
     */
    private fun isMentaDynamic(expression: IrDynamicMemberExpression): Boolean =
        expression.receiver.type !is IrDynamicType

    private fun transformDynamicGet(expression: IrDynamicMemberExpression): IrExpression {
        val binderCall = IrConstructorCallImpl(
            expression.startOffset, expression.endOffset,
            symbols.getMemberBinderClass.defaultType,
            symbols.getMemberBinderConstructor,
            typeArgumentsCount = 0,
            constructorTypeArgumentsCount = 0,
        ).apply {
            arguments[0] = IrConstImpl.string(
                expression.startOffset, expression.endOffset,
                irBuiltIns.stringType,
                expression.memberName,
            )
        }

        return IrCallImpl(
            expression.startOffset, expression.endOffset,
            irBuiltIns.anyNType,
            symbols.tryGetMember,
            typeArgumentsCount = 0,
        ).apply {
            dispatchReceiver = expression.receiver
            arguments[1] = binderCall
        }
    }

    private fun buildSetCall(
        expression: IrDynamicOperatorExpression,
        memberName: String,
        receiver: IrExpression,
        value: IrExpression,
    ): IrExpression {
        val binderCall = IrConstructorCallImpl(
            expression.startOffset, expression.endOffset,
            symbols.setMemberBinderClass.defaultType,
            symbols.setMemberBinderConstructor,
            typeArgumentsCount = 0,
            constructorTypeArgumentsCount = 0,
        ).apply {
            arguments[0] = IrConstImpl.string(
                expression.startOffset, expression.endOffset,
                irBuiltIns.stringType,
                memberName,
            )
        }

        return IrCallImpl(
            expression.startOffset, expression.endOffset,
            irBuiltIns.booleanType,
            symbols.trySetMember,
            typeArgumentsCount = 0,
        ).apply {
            dispatchReceiver = receiver
            arguments[1] = binderCall
            arguments[2] = value
        }
    }

    private fun buildInvokeCall(
        expression: IrDynamicOperatorExpression,
        memberName: String,
        receiver: IrExpression,
        args: List<IrExpression>,
    ): IrExpression {
        val receiverClass = receiver.type.classOrNull?.owner
        if (receiverClass != null && hasFunction(receiverClass, memberName)) {
            val function = receiverClass.declarations.filter { it is IrFunction }.map { it as IrSimpleFunction }.single { it.name.asString() == memberName }
            return IrCallImpl(
                expression.startOffset, expression.endOffset,
                function.returnType,
                function.symbol,
                typeArgumentsCount = 0,
            ).apply {
                dispatchReceiver = receiver
                for ((i, arg) in args.withIndex()) {
                    arguments[i] = arg
                }
            }
        } else {
            val argsArray = IrVarargImpl(
                expression.startOffset, expression.endOffset,
                irBuiltIns.arrayClass.typeWith(irBuiltIns.anyNType),
                irBuiltIns.anyNType,
                args,
            )

            val binderCall = IrConstructorCallImpl(
                expression.startOffset, expression.endOffset,
                symbols.invokeMemberBinderClass.defaultType,
                symbols.invokeMemberBinderConstructor,
                typeArgumentsCount = 0,
                constructorTypeArgumentsCount = 0,
            ).apply {
                arguments[0] = IrConstImpl.string(
                    expression.startOffset, expression.endOffset,
                    irBuiltIns.stringType,
                    memberName,
                )
                arguments[1] = argsArray
            }

            return IrCallImpl(
                expression.startOffset, expression.endOffset,
                irBuiltIns.anyNType,
                symbols.tryInvokeMember,
                typeArgumentsCount = 0,
            ).apply {
                dispatchReceiver = receiver
                arguments[1] = binderCall
            }
        }
    }
}
