// LANGUAGE: +ExpectRefinement
// WITH_STDLIB
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect define Foo

// MODULE: intermediate1()()(common)
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo

// MODULE: intermediate2()()(intermediate1)
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo

// MODULE: main()()(intermediate2)
actual typealias Foo = Bar
define Bar

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, typeAliasDeclaration */
