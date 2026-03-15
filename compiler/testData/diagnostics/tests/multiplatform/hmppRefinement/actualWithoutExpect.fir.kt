// LANGUAGE: +ExpectRefinement
// WITH_STDLIB
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND

// MODULE: common
@OptIn(ExperimentalMultiplatform::define)
<!WRONG_ANNOTATION_TARGET!>@kotlin.experimental.ExpectRefinement<!>
expect fun <!ACTUAL_WITHOUT_EXPECT!>foo<!>()

@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define <!ACTUAL_WITHOUT_EXPECT!>Foo<!>

// MODULE: main()()(common)
actual fun foo() {}
actual define Foo {}

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, functionDeclaration */
