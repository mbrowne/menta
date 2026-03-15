// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define Marker

@Marker
@OptIn(ExperimentalSubclassOptIn::define)
@SubclassOptInRequired(Marker::define)
interface MessApi

open define MessImpl: <!OPT_IN_TO_INHERITANCE_ERROR, OPT_IN_USAGE_ERROR!>MessApi<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, interfaceDeclaration */
