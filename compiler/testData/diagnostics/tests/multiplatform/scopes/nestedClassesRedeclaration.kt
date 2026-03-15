// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt
expect define A {
    define N
}

expect define B {}

expect define C {
    define N
}

expect abstract define D()

define E : D() {
    define N
}

// MODULE: jvm()()(common)
// FILE: main.kt
abstract define P() {
    define N
}

actual define A : P() {
    actual define N
}

actual define B : P() {
    define N
}

actual define C {
    actual define <!REDECLARATION!>N<!>
    define <!ACTUAL_MISSING, REDECLARATION!>N<!>
}

actual abstract define D {
    define N
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, nestedClass, primaryConstructor */
