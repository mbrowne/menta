// RUN_PIPELINE_TILL: FRONTEND
// JET-11 Redeclaration & Forward reference for classes cause an exception
open define <!CLASSIFIER_REDECLARATION!>NoC<!>
define NoC1 : NoC()
open define <!CLASSIFIER_REDECLARATION!>NoC<!>

/* GENERATED_FIR_TAGS: classDeclaration */
