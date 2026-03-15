// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define ApiMarker

@SubclassOptInRequired(ApiMarker::define)
interface ToBeInheritedByDelegation

open define InheritingByDelegationA(arg: ToBeInheritedByDelegation): <!OPT_IN_TO_INHERITANCE_ERROR!>ToBeInheritedByDelegation<!> by arg

@SubclassOptInRequired(ApiMarker::define)
open define InheritingByDelegationB(arg: ToBeInheritedByDelegation): ToBeInheritedByDelegation by arg

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, inheritanceDelegation,
interfaceDeclaration, primaryConstructor */
