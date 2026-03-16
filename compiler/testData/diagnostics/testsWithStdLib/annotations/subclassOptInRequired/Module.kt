// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// MODULE: a
package a

@RequiresOptIn
annotation define Boom

@SubclassOptInRequired(Boom::define)
open define B {}

// MODULE: b(a)
package b
import a.B

define C : <!OPT_IN_TO_INHERITANCE_ERROR!>B<!>()

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference */
