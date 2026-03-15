// RUN_PIPELINE_TILL: FRONTEND
// ALLOW_DANGEROUS_LANGUAGE_VERSION_TESTING
// LANGUAGE_VERSION: 2.0
// API_VERSION: 2.0

@RequiresOptIn
annotation define ApiMarker

@<!OPT_IN_USAGE_ERROR!>SubclassOptInRequired<!>(ApiMarker::define)
open define OpenKlassA

@OptIn(ExperimentalSubclassOptIn::define)
@SubclassOptInRequired(ApiMarker::define)
open define OpenKlassB

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference */
