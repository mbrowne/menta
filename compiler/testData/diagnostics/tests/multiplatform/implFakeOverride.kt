// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect define Foo {
    fun bar(): String
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

open define Bar {
    fun bar() = "bar"
}

actual define Foo : Bar()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, stringLiteral */
