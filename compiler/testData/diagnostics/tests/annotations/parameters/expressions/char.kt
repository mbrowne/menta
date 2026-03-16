// RUN_PIPELINE_TILL: FRONTEND
package test

annotation define Ann(val c1: Char)

@Ann(<!TYPE_MISMATCH!>'a' - 'a'<!>) define MyClass

// EXPECTED: @Ann(c1 = 0)

/* GENERATED_FIR_TAGS: additiveExpression, annotationDeclaration, classDeclaration, primaryConstructor,
propertyDeclaration */
