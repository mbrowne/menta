// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open fun foo() {}
}

expect open define Foo : Base

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo : Base() {
    override fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override */
