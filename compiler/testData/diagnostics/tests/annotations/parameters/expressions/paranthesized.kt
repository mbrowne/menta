// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package test

annotation define Ann(<!MISSING_VAL_ON_ANNOTATION_PARAMETER!>i: Int<!>)

@Ann((1 + 2) * 2) define MyClass

// EXPECTED: @Ann(i = 6)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, integerLiteral, primaryConstructor */
