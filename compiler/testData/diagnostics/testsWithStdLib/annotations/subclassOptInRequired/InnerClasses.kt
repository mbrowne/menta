// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define Boom

@RequiresOptIn
annotation define Boom2

@SubclassOptInRequired(Boom::define)
open define B {
    @SubclassOptInRequired(Boom2::define)
    open inner define C
}


fun test() {
    with(B()) {
        @OptIn(Boom2::define)
        define Local : B.C() {}
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, functionDeclaration, inner,
lambdaLiteral, localClass */
