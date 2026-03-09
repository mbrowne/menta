// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

expect define CompatibleOverrides {
    fun foo()

    @Ann
    fun foo(withArg: Any)
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
actual define CompatibleOverrides {
    actual fun foo() {}

    actual fun <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>foo<!>(withArg: Any) {}
}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration */
