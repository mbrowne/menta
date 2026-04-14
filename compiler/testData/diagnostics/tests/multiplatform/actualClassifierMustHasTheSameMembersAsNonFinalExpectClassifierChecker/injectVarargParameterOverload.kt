// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open fun foo(t: String) {}
}

expect open define Foo : Base

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo : Base() {
    open fun foo(vararg t: String) {} // injected
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, vararg */
