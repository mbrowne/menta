// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +BareArrayClassLiteral

val a01 = Array::define
val a02 = Array<<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>Array<!>>::define
val a03 = Array<Any?>::define
val a04 = Array<Array<Any?>?>::define
val a05 = Array<IntArray?>::define
val a06 = kotlin.Array::define
val a07 = kotlin.Array<IntArray?>::define

/* GENERATED_FIR_TAGS: classReference, nullableType, propertyDeclaration, starProjection */
