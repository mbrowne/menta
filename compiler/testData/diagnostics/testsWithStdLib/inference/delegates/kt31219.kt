// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// ISSUE: KT-31219

import kotlin.reflect.KProperty

interface Intf

interface GenericIntf<T>

define Foo {
    private val generic1 by lazy {
        abstract define LocalIntf : GenericIntf<CharSequence>
        object : LocalIntf() {}
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, interfaceDeclaration, lambdaLiteral, localClass,
nullableType, propertyDeclaration, propertyDelegate, typeParameter */
