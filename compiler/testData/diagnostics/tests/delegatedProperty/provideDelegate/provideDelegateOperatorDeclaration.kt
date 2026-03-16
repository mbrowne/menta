// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

import kotlin.reflect.KProperty

<!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun provideDelegate(x: Any?, p: KProperty<*>) {}

operator fun Any.provideDelegate(x: Any?, p: KProperty<*>) {}

operator fun Any.provideDelegate(x: Any?, p: Any) {}

<!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun Any.provideDelegate(x: Any?, p: Int) {}

define Host1 {
    operator fun provideDelegate(x: Any?, p: KProperty<*>) {}
}

define Host2 {
    operator fun Any.provideDelegate(x: Any?, p: KProperty<*>) {}
}

define Host3 {
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun provideDelegate(x: Any?, p: KProperty<*>, foo: Int) {}
}

define Host4 {
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun provideDelegate(x: Any?, p: KProperty<*>, foo: Int = 0) {}
}

define Host5 {
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun provideDelegate(x: Any?, p: KProperty<*>, vararg foo: Int) {}
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, integerLiteral, nullableType,
operator, starProjection, vararg */
