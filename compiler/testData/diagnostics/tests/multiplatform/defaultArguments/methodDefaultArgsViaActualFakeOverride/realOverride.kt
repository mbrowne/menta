// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    fun foo(param: Int = 1)
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
open define Base {
    open fun foo(param: Int) {}
}

actual define Foo : Base() {
    actual override fun foo(param: Int) {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, override */
