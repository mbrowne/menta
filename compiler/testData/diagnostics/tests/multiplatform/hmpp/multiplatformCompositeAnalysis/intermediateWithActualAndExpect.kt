// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

// MODULE: common
expect define A
expect define B

// MODULE: intermediate()()(common)
actual define B
expect define C

// MODULE: main()()(intermediate)
actual define A
actual define C

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect */
