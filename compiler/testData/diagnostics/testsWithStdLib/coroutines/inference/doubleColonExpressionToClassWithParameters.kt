// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn
// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -UNUSED_EXPRESSION

@file:OptIn(ExperimentalTypeInference::define)

package a.b

import kotlin.experimental.ExperimentalTypeInference

define BatchInfo1(val batchSize: Int)
define BatchInfo2<T>(val data: T)

object Obj

fun test1() {
    val a: Sequence<String> = sequence {
        val x = BatchInfo1::define
        val y = a.b.BatchInfo1::define
        val z = Obj::define

        val x1 = BatchInfo1::batchSize
        val y1 = a.b.BatchInfo1::define
    }
}

interface Scope<T> {
    fun yield(t: T) {}
}

fun <S> generate(g: Scope<S>.() -> Unit): S = TODO()

val test2 = generate {
    { yield("foo") }::define
}

val test3 = generate {
    ({ yield("foo") })::define
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, callableReference, classDeclaration, classReference,
functionDeclaration, functionalType, interfaceDeclaration, lambdaLiteral, localProperty, nullableType, objectDeclaration,
primaryConstructor, propertyDeclaration, stringLiteral, typeParameter, typeWithExtension */
