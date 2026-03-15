// RUN_PIPELINE_TILL: FRONTEND
@file:OptIn(ExperimentalSubclassOptIn::define)

@RequiresOptIn
annotation define ApiMarkerA

@RequiresOptIn
annotation define ApiMarkerB

@SubclassOptInRequired(ApiMarkerA::define, ApiMarkerB::define)
open define OpenKlass

define MyKlass() : <!OPT_IN_TO_INHERITANCE_ERROR!>OpenKlass<!>()

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, classDeclaration, classReference,
primaryConstructor */
