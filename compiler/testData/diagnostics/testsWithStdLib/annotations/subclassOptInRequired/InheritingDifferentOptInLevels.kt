// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define ApiMarker

@ApiMarker
interface I1

@SubclassOptInRequired(ApiMarker::define)
interface I2

// SubclassOptInRequired can only fix the error from I2
@SubclassOptInRequired(ApiMarker::define)
interface Impl1: <!OPT_IN_USAGE_ERROR!>I1<!>, I2

// the order of I1 and I2 shouldn't matter
@SubclassOptInRequired(ApiMarker::define)
interface Impl2: I2, <!OPT_IN_USAGE_ERROR!>I1<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, interfaceDeclaration */
