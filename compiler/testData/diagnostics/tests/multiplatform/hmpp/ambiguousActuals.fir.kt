// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: common
<!AMBIGUOUS_ACTUALS{JVM}!>expect<!> fun foo()
expect define Foo

// MODULE: intermediate()()(common)
actual <!CONFLICTING_OVERLOADS!>fun foo()<!> {}
actual define <!CLASSIFIER_REDECLARATION!>Foo<!>

// MODULE: main()()(common, intermediate)
actual fun foo() {}
actual define Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration */
