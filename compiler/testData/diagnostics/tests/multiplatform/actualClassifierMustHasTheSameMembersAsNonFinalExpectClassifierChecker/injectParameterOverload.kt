// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect open define Foo {
    fun foo()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo {
    actual fun foo() {}

    fun foo(overloaded: Int) {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
