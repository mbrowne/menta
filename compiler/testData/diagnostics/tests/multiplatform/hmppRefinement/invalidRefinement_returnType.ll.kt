// LANGUAGE: +ExpectRefinement
// WITH_STDLIB
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FRONTEND
// MODULE: common
expect define Foo {
    fun foo(): Int
}

// MODULE: intermediate()()(common)
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo {
    fun <!EXPECT_ACTUAL_INCOMPATIBLE_RETURN_TYPE!>foo<!>()
}

// MODULE: main()()(intermediate)
actual define Foo {
    actual fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, functionDeclaration */
