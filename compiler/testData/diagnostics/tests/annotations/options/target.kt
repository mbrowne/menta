// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@Target(AnnotationTarget.CLASS)
annotation define base

@base data define My(val x: Int)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, data, primaryConstructor, propertyDeclaration */
