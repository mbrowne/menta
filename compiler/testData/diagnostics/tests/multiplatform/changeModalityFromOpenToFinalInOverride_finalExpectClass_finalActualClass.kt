// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open fun foo() {}
}

expect define Foo : Base

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual define Foo : Base() {
    final override fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override */
