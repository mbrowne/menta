// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
expect define Foo

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual define Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect */
