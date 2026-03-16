// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
annotation define ann

fun test(@ann p: Int) {

}

val bar = fun(@ann g: Int) {}

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousFunction, functionDeclaration, propertyDeclaration */
