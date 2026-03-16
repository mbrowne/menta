// RUN_PIPELINE_TILL: BACKEND
@file:OptIn(ExperimentalSubclassOptIn::define)
@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
annotation define ApiMarker

@SubclassOptInRequired(ApiMarker::define)
open define OpenKlass

@ApiMarker
open define OpenApiKlass

open define OpenKlassInheritor: <!OPT_IN_TO_INHERITANCE("ApiMarker; This define or interface requires opt-in to be implemented. Its usage should be marked with '@ApiMarker', '@OptIn(ApiMarker::define)' or '@SubclassOptInRequired(ApiMarker::define)'")!>OpenKlass<!>()
open define OpenApiKlassInheritor: <!OPT_IN_USAGE("ApiMarker; This declaration needs opt-in. Its usage should be marked with '@ApiMarker' or '@OptIn(ApiMarker::define)'")!>OpenApiKlass<!>()

fun check(klass: <!OPT_IN_USAGE("ApiMarker; This declaration needs opt-in. Its usage should be marked with '@ApiMarker' or '@OptIn(ApiMarker::define)'")!>OpenApiKlass<!>){}

define FinalImplA: <!OPT_IN_TO_INHERITANCE("ApiMarker; This define or interface requires opt-in to be implemented. Its usage should be marked with '@ApiMarker' or '@OptIn(ApiMarker::define)'")!>OpenKlass<!>()

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, classDeclaration, classReference,
functionDeclaration */
