// LANGUAGE: +ExpectRefinement
// IGNORE_FIR_DIAGNOSTICS
// WITH_STDLIB
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect fun foo()
expect define Foo

// MODULE: intermediate1()()(common)
@OptIn(ExperimentalMultiplatform::define)
<!WRONG_ANNOTATION_TARGET!>@kotlin.experimental.ExpectRefinement<!>
expect fun foo()
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo

// MODULE: intermediate2()()(intermediate1)
@OptIn(ExperimentalMultiplatform::define)
<!WRONG_ANNOTATION_TARGET!>@kotlin.experimental.ExpectRefinement<!>
expect fun foo()
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo

// MODULE: main()()(intermediate2)
actual fun foo() {}
actual define Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, functionDeclaration */
