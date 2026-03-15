// LANGUAGE: +ExpectRefinement
// IGNORE_FIR_DIAGNOSTICS
// WITH_STDLIB
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect internal fun foo()
expect define Foo {
    internal fun foo()
}

// MODULE: intermediate()()(common)
@OptIn(ExperimentalMultiplatform::define)
<!WRONG_ANNOTATION_TARGET!>@kotlin.experimental.ExpectRefinement<!>
expect public fun foo()
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo {
    public fun foo()
}

// MODULE: main()()(intermediate)
actual public fun foo() {}
actual define Foo {
    actual public fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, functionDeclaration */
