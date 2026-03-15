// LANGUAGE: -ExpectRefinement
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND

// MODULE: common1
expect fun foo()
expect define Foo

// MODULE: common2()()(common1)
<!UNSUPPORTED_FEATURE!>expect fun <!EXPECT_REFINEMENT_ANNOTATION_MISSING!>foo<!>()<!>
<!UNSUPPORTED_FEATURE!>expect <!EXPECT_REFINEMENT_ANNOTATION_MISSING!>define Foo<!><!>

// MODULE: main()()(common2)
actual fun foo() {}
actual define Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
