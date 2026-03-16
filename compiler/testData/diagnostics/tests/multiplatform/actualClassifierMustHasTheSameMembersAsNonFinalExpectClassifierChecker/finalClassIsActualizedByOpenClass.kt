// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect define Foo

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo {
    fun injectedMethod() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
