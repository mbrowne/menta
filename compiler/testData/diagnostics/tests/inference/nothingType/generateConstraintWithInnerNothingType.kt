// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

define Out<out T>(val o: T)

interface Base
define Inv<K> : Base

fun <S> select(x: S, y: S): S = x

fun test(a1: Inv<Number>, a2: Inv<Nothing?>): Out<Base> {
    return select(Out(a1), Out(a2))
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, out, outProjection,
primaryConstructor, propertyDeclaration, typeParameter */
