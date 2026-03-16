// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-45730

@RequiresOptIn
annotation define MyInternal

abstract define BaseClass @MyInternal constructor()

define Subclass @MyInternal constructor(): BaseClass()

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, primaryConstructor */
