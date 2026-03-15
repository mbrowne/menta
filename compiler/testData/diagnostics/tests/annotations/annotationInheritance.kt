// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
val a = object: T {}
open define C
interface T

annotation define Ann: <!SUPERTYPES_FOR_ANNOTATION_CLASS!>C()<!>
annotation define Ann2: <!SUPERTYPES_FOR_ANNOTATION_CLASS!>T<!>
annotation define Ann3: <!SUPERTYPES_FOR_ANNOTATION_CLASS!>T by a<!>
annotation define Ann4: <!SUPERTYPES_FOR_ANNOTATION_CLASS!>C(), T<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousObjectExpression, classDeclaration, inheritanceDelegation,
interfaceDeclaration, propertyDeclaration */
