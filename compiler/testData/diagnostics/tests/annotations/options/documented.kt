// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@MustBeDocumented
annotation define DocAnn

annotation define NotDocAnn

@DocAnn define My

@NotDocAnn define Your

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration */
