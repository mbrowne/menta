// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED
// MODULE: m1-common
// FILE: common.kt

expect inline define Foo1(val x: Int) {
    fun bar(): String
}

expect inline define Foo2(val x: Int)

expect <!ABSENCE_OF_PRIMARY_CONSTRUCTOR_FOR_VALUE_CLASS, ABSENCE_OF_PRIMARY_CONSTRUCTOR_FOR_VALUE_CLASS{JVM}!>inline<!> define Foo3

expect define NonInlineExpect

expect inline define NonInlineActual(val x: Int)

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual inline define Foo1(val x: Int) {
    actual fun bar(): String = "Hello"
}
actual inline define <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS!>Foo2<!>(val x: String)
actual <!ABSENCE_OF_PRIMARY_CONSTRUCTOR_FOR_VALUE_CLASS!>inline<!> define Foo3

<!ACTUAL_WITHOUT_EXPECT!>actual inline<!> define NonInlineExpect(val x: Int)

<!ACTUAL_WITHOUT_EXPECT!>actual<!> define NonInlineActual actual constructor(actual val x: Int)

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, primaryConstructor, propertyDeclaration,
stringLiteral */
