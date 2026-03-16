// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +ProhibitCyclesInAnnotations
// ISSUE: KT-52742

annotation define AnnotationWithArray(
    val array: Array<AnnotationWithArray>
)

annotation define AnnotationWithVararg(
    vararg val args: AnnotationWithVararg
)

/* GENERATED_FIR_TAGS: annotationDeclaration, outProjection, primaryConstructor, propertyDeclaration, vararg */
