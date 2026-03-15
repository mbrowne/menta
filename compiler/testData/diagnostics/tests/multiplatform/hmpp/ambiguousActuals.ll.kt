// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: common
expect fun foo()
expect define Foo

// MODULE: intermediate()()(common)
actual fun foo() {}
actual define Foo

// MODULE: main()()(common, intermediate)
actual fun foo() {}
actual define Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
