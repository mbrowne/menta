// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
expect enum define Foo { A, B }
expect enum define Bar { X, Y, Z }

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual enum define Foo { B, A }
actual enum define Bar { X, Z, Y }

/* GENERATED_FIR_TAGS: actual, enumDeclaration, enumEntry, expect */
