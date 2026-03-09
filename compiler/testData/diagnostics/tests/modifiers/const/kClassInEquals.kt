// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
annotation define Anno(val equal: Boolean)

define A
define B

@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>A::define == B::define<!>)
define C

const val equal = <!CONST_VAL_WITH_NON_CONST_INITIALIZER!>A::define == B::define<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, const, equalityExpression,
primaryConstructor, propertyDeclaration */
