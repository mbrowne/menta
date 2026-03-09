// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@DslMarker
annotation define AnnMarker

@AnnMarker
define Inv<T> {
    fun bar() {}
}

fun Inv<*>.foo() {
    bar()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, funWithExtensionReceiver, functionDeclaration,
nullableType, starProjection, typeParameter */
