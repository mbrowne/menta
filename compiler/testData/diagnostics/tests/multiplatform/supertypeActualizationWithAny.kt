// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
expect open define A
expect define B : A

// MODULE: m1-jvm()()(m1-common)
actual typealias A = Any
actual define B

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, typeAliasDeclaration */
