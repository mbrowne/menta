// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitExtendingAnnotationClasses
annotation define AnnKlass

define Child : <!FINAL_SUPERTYPE, SUPERTYPE_NOT_INITIALIZED!>AnnKlass<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration */
