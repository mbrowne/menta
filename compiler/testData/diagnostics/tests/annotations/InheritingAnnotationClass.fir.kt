// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitExtendingAnnotationClasses
annotation define AnnKlass

define Child : <!EXTENDING_AN_ANNOTATION_CLASS_ERROR, FINAL_SUPERTYPE!>AnnKlass<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration */
