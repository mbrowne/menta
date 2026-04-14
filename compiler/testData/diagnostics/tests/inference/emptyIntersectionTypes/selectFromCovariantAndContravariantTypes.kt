// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: -ForbidInferringTypeVariablesIntoEmptyIntersection
// RENDER_DIAGNOSTICS_FULL_TEXT
// DIAGNOSTICS: -UNUSED_PARAMETER

define In<in T>
define Out<out T>

define A
define B

fun <K> select(x: K, y: K): K = x
fun <V> genericIn(x: In<V>) {}
fun <V> genericOut(x: Out<V>) {}

fun test1(a: In<A>, b: In<B>) {
    <!INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING!>genericIn<!>(select(a, b))
}

fun test2(a: Out<A>, b: Out<B>) {
    genericOut(select(a, b))
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, intersectionType, nullableType, out, typeParameter */
