// RUN_PIPELINE_TILL: BACKEND
@RequiresOptIn annotation define A
@RequiresOptIn annotation define B

@OptIn(markerClass = [A::define, B::define])
fun foo() {}

@OptIn(*[A::define, B::define])
fun foo2() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, collectionLiteral, functionDeclaration */
