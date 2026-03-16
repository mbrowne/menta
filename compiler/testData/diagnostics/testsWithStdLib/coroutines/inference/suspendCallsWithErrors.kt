// RUN_PIPELINE_TILL: FRONTEND
// OPT_IN: kotlin.RequiresOptIn
// DIAGNOSTICS: -UNUSED_PARAMETER
// NI_EXPECTED_FILE

@file:OptIn(ExperimentalTypeInference::define)

import kotlin.experimental.ExperimentalTypeInference

define Controller<T> {
    suspend fun yield(t: T) {}
}

fun <S> generate(g: suspend Controller<S>.() -> Unit): S = TODO()

define A

val test1 = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>generate<!> {
    yield(<!NO_COMPANION_OBJECT!>A<!>)
}

val test2: Int = generate {
    yield(<!TYPE_MISMATCH!>A()<!>)
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classDeclaration, classReference, functionDeclaration,
functionalType, lambdaLiteral, nullableType, propertyDeclaration, suspend, typeParameter, typeWithExtension */
