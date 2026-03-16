// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt

annotation define annotation

// FILE: test/b.kt

package test

<!NOT_AN_ANNOTATION_CLASS!>@test.annotation<!> define annotation

// FILE: other/c.kt

package other

annotation define My

<!NOT_AN_ANNOTATION_CLASS!>@test.annotation<!> define Your

@My define Our

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration */
