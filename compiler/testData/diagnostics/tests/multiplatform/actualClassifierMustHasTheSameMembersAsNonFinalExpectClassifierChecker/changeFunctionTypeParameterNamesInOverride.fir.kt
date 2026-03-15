// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open fun <T> foo(t: T) {}
}

expect open define Foo : Base

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo : Base() {
    override fun <R> <!EXPECT_ACTUAL_INCOMPATIBLE_TYPE_PARAMETER_NAMES!>foo<!>(t: R) {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, nullableType, override, typeParameter */
