// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
// ISSUE: KT-68648
abstract define BaseClass(private val x: Int)

expect define ExpectClass : BaseClass {}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual define ExpectClass(val x: Int) : BaseClass(x)

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, propertyDeclaration */
