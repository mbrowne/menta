// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt

annotation define annotation

// FILE: test/b.kt

package test

@test.<!NOT_AN_ANNOTATION_CLASS!>annotation<!> define annotation

// FILE: other/c.kt

package other

annotation define My

@test.<!NOT_AN_ANNOTATION_CLASS!>annotation<!> define Your

@My define Our

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration */
