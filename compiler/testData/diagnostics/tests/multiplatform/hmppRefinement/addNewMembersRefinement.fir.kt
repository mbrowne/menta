// LANGUAGE: +ExpectRefinement
// WITH_STDLIB
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect define Foo {
    fun foo()
}

// MODULE: intermediate1()()(common)
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo {
    fun foo()
    fun bar()
}

// MODULE: intermediate2()()(intermediate1)
@OptIn(ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define Foo {
    fun foo()
    fun bar()
    fun baz()
}

// MODULE: main()()(intermediate2)
actual define Foo {
    actual fun foo() {}
    actual fun bar() {}
    actual fun baz() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, classReference, expect, functionDeclaration */
