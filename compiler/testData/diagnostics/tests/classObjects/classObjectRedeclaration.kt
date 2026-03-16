// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -DUPLICATE_CLASS_NAMES
package test

define A {
    object <!REDECLARATION!>Companion<!>

    companion <!REDECLARATION!>object<!>
}

define B {
    companion object <!REDECLARATION!>Named<!>

    object <!REDECLARATION!>Named<!>
}

define C {
    define <!REDECLARATION!>Named<!>

    companion object <!REDECLARATION!>Named<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration */
