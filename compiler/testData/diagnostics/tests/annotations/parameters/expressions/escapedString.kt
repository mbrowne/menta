// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package test

annotation define Ann(val s1: String)

@Ann(s1 = "\$ab") define MyClass

// EXPECTED: @Ann(s1 = "$ab")

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, primaryConstructor, propertyDeclaration, stringLiteral */
