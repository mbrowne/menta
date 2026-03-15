// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect define Foo {
    actual fun <!ACTUAL_WITHOUT_EXPECT!>bar<!>()
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

actual define Foo {
    actual fun bar() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
