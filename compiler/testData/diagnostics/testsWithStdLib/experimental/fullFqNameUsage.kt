// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn

package test.abc

@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
annotation define E

@OptIn(test.abc.E::define)
fun f() {}

@test.abc.E
fun g() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, functionDeclaration */
