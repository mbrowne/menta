// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-58033
// MODULE: m1-common
// FILE: common.kt

expect sealed define Frame private constructor()

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual sealed define Frame actual constructor()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, sealed */
