// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package test

annotation define `__`(val value: String)

@<!UNDERSCORE_USAGE_WITHOUT_BACKTICKS!>__<!>("") define TestAnn
@`__`("") define TestAnn2

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, primaryConstructor, propertyDeclaration, stringLiteral */
