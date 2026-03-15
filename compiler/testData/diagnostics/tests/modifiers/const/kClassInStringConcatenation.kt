// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
annotation define Anno(val str: String)

@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>"${A::define}"<!>)
define A

@Anno(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>B::define.toString()<!>)
define B

const val a = <!CONST_VAL_WITH_NON_CONST_INITIALIZER!>"${A::define}"<!>
const val b = <!CONST_VAL_WITH_NON_CONST_INITIALIZER!>B::define.toString()<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, const, primaryConstructor,
propertyDeclaration */
