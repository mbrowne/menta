// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package test

annotation define Ann(<!MISSING_VAL_ON_ANNOTATION_PARAMETER!>i: Double<!>)

@Ann(A@ 1.0) define MyClass

// EXPECTED: @Ann(i = 1.0.toDouble())

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, primaryConstructor */
