// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt

expect define Foo {
    fun bar(): String
    fun bas(f: Int)
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual define Foo {
    fun <!ACTUAL_MISSING!>bar<!>(): String = "bar"
    fun <!ACTUAL_MISSING!>bas<!>(g: Int) {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, stringLiteral */
