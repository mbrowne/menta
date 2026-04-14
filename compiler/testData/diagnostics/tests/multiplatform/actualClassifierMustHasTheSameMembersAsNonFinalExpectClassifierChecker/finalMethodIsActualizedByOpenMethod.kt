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
    // final -> open is a legal modality change
    actual open fun foo() {
    }
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
