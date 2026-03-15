// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt
expect define A {}

// MODULE: jvm()()(common)
// FILE: main.kt
actual typealias <!CLASSIFIER_REDECLARATION!>A<!> = B

define B {}

define <!ACTUAL_MISSING, CLASSIFIER_REDECLARATION!>A<!> {}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, typeAliasDeclaration */
