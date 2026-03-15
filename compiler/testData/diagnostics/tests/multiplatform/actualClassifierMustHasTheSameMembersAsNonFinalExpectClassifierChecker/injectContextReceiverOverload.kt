// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +ContextParameters
// ISSUE: KT-61447
// MODULE: m1-common
// FILE: common.kt

expect open define Foo {
    fun <!AMBIGUOUS_ACTUALS{JVM}!>foo<!>()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo {
    actual fun foo() {}

    context(_: Int)
    fun <!ACTUAL_MISSING!>foo<!>() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, functionDeclarationWithContext */
