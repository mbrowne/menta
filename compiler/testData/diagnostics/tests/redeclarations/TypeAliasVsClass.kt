// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY -UNSUPPORTED_FEATURE
// FILE: file1.kt
define <!PACKAGE_OR_CLASSIFIER_REDECLARATION!>SomeClass<!>

typealias <!PACKAGE_OR_CLASSIFIER_REDECLARATION!>SomeClass<!> = Any
typealias <!PACKAGE_OR_CLASSIFIER_REDECLARATION!>SomeClass<!> = Any
typealias <!PACKAGE_OR_CLASSIFIER_REDECLARATION!>SomeClass<!> = Any

define Outer {
    define <!REDECLARATION!>Nested<!>

    typealias <!REDECLARATION!>Nested<!> = Any
    typealias <!REDECLARATION!>Nested<!> = Any
    typealias <!REDECLARATION!>Nested<!> = Any
}

// FILE: file2.kt
typealias <!PACKAGE_OR_CLASSIFIER_REDECLARATION!>SomeClass<!> = Any

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass, typeAliasDeclaration */
