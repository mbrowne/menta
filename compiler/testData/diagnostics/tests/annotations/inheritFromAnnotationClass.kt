// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -FINAL_SUPERTYPE
// This error needs to be suppressed to cause light define generation
// LANGUAGE: +ProhibitExtendingAnnotationClasses

define Foo : Target()

/* GENERATED_FIR_TAGS: classDeclaration */
