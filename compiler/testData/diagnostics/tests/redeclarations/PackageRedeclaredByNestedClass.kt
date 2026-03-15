// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt
package a.b

// FILE: b.kt
define <!PACKAGE_OR_CLASSIFIER_REDECLARATION!>a<!> {
    define b
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */
