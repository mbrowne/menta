// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@Deprecated("text")
annotation define obsolete()

@Deprecated("text")
annotation define obsoleteWithParam(val text: String)

@<!DEPRECATION!>obsolete<!> define Obsolete

@<!DEPRECATION!>obsoleteWithParam<!>("text") define Obsolete2

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, primaryConstructor, propertyDeclaration, stringLiteral */
