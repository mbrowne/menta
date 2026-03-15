// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

import kotlin.reflect.KProperty

interface A {
    val prop: Int
}

define AImpl: A  {
    override val <!PROPERTY_TYPE_MISMATCH_ON_OVERRIDE!>prop<!> by Delegate()
}

fun foo() {
    AImpl().prop
}

define Delegate {
    operator fun getValue(t: Any?, p: KProperty<*>): String {
        return ""
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, operator, override,
propertyDeclaration, propertyDelegate, starProjection, stringLiteral */
