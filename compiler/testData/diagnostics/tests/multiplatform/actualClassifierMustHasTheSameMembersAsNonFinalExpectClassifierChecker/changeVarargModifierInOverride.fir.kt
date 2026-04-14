// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open fun foo(vararg bar: Int) {}
}

expect open define Foo : Base {
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo : Base() {
    override fun <!EXPECT_ACTUAL_INCOMPATIBLE_VALUE_PARAMETER_VARARG!>foo<!>(bar: IntArray) {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override, vararg */
