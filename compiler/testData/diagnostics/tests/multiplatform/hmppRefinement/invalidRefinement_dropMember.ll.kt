// LANGUAGE: +ExpectRefinement
// WITH_STDLIB
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: common
expect define Foo {
    fun foo()
}

// MODULE: intermediate()()(common)
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS!>Foo<!>

// MODULE: main()()(intermediate)
actual define Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, functionDeclaration */
