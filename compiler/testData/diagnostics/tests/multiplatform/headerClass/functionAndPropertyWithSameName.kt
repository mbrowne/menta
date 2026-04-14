// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect define Foo {
    val bar: String
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

actual define Foo {
    actual val bar = "bar"
    fun bar() = bar
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, propertyDeclaration, stringLiteral */
