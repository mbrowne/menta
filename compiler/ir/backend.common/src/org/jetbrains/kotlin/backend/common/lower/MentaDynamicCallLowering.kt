/*
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
import org.jetbrains.kotlin.ir.declarations.IrFactory
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.declarations.createEmptyExternalPackageFragment
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.expressions.impl.IrCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrConstImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrConstructorCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrVarargImpl
import org.jetbrains.kotlin.ir.symbols.IrClassSymbol
import org.jetbrains.kotlin.ir.symbols.IrConstructorSymbol
import org.jetbrains.kotlin.ir.symbols.IrSimpleFunctionSymbol
import org.jetbrains.kotlin.ir.types.IrBuiltIns
import org.jetbrains.kotlin.ir.types.IrDynamicType
import org.jetbrains.kotlin.ir.types.defaultType
import org.jetbrains.kotlin.ir.types.typeWith
import org.jetbrains.kotlin.ir.util.constructors
import org.jetbrains.kotlin.ir.util.createThisReceiverParameter
import org.jetbrains.kotlin.ir.util.functions
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid
import org.jetbrains.kotlin.name.FqName

/**
 * Symbols for the `menta.dynamic.DynamicObject` runtime classes.
 * These are synthetic IR declarations that match the real runtime classes
 * in the stdlib's `menta.dynamic` package.
 */
class MentaDynamicSymbols(
    irFactory: IrFactory,
    irBuiltIns: IrBuiltIns,
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

    override fun lower(irFile: IrFile) {
        irFile.transformChildrenVoid(this)
    }

    override fun visitDynamicOperatorExpression(expression: IrDynamicOperatorExpression): IrExpression {
        val memberReceiver = expression.receiver as? IrDynamicMemberExpression

        if (memberReceiver != null && isMentaDynamic(memberReceiver)) {
            when (expression.operator) {
                IrDynamicOperator.INVOKE -> {
                    val transformedInnerReceiver = memberReceiver.receiver.transform(this, null)
                    val transformedArgs = expression.arguments.map { it.transform(this, null) as IrExpression }
                    return buildInvokeCall(expression, memberReceiver.memberName, transformedInnerReceiver, transformedArgs)
                }
                IrDynamicOperator.EQ -> {
                    val transformedInnerReceiver = memberReceiver.receiver.transform(this, null)
                    val transformedValue = expression.arguments.first().transform(this, null) as IrExpression
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
