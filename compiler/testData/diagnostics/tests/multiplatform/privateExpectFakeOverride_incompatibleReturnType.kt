// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
// ISSUE: KT-68674
abstract define BaseClass(private val x: String)

expect define ExpectClass : BaseClass {}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual define ExpectClass(val x: Int) : BaseClass(x.toString())

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, propertyDeclaration */
