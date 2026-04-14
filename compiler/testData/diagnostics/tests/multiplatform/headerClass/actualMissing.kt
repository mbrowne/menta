// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect define A {
    fun foo()
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

define <!ACTUAL_MISSING!>A<!> {
    actual fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
