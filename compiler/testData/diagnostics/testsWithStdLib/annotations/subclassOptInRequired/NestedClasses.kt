// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define Boom

@RequiresOptIn
annotation define Boom2

@SubclassOptInRequired(Boom::define)
open define B {
    @SubclassOptInRequired(Boom2::define)
    open define C

    @OptIn(Boom2::define)
    define C2 : C()
}

@OptIn(Boom2::define)
define E2 : B.C() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, nestedClass */
