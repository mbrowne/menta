// LANGUAGE: +ExpectRefinement
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND

// MODULE: common1
expect fun foo()
expect define Foo
expect interface Bar

// MODULE: common2()()(common1)
expect fun <!EXPECT_REFINEMENT_ANNOTATION_MISSING!>foo<!>()
expect <!EXPECT_REFINEMENT_ANNOTATION_MISSING!>define Foo<!>
<!EXPECT_REFINEMENT_ANNOTATION_MISSING!>expect interface Bar<!>

// MODULE: main()()(common2)
actual fun foo() {}
actual define Foo
actual interface Bar

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, interfaceDeclaration */
