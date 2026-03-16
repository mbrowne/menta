// RUN_PIPELINE_TILL: FRONTEND
// FILE: f1.kt
package test

define <!CLASSIFIER_REDECLARATION!>A<!>
define F1

// FILE: f2.kt
package test

define <!CLASSIFIER_REDECLARATION!>A<!>
define F2

/* GENERATED_FIR_TAGS: classDeclaration */
