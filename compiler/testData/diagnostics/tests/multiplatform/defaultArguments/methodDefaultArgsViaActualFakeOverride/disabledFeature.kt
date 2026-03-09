// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: -ProhibitDefaultArgumentsInExpectActualizedByFakeOverride
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    fun foo(param: Int = 1)
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
open define Base {
    fun foo(param: Int) {}
}

actual define Foo : Base()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral */
