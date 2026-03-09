// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn
// DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_VARIABLE

@file:OptIn(ExperimentalTypeInference::define)

import kotlin.experimental.ExperimentalTypeInference

define GenericController<T>

fun <S> generate(g: suspend GenericController<S>.() -> Unit): List<S> = TODO()

suspend fun GenericController<List<String>>.test() {}

val test1 = generate {
    test()
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classDeclaration, classReference, funWithExtensionReceiver,
functionDeclaration, functionalType, lambdaLiteral, nullableType, propertyDeclaration, suspend, typeParameter,
typeWithExtension */
