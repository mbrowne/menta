// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A
open define B: A()
open define D

open define Base<out T, out U>
open define Derived<out S>: Base<S, S>()

fun test(a: Base<B, D>) = a is <!CANNOT_CHECK_FOR_ERASED!>Derived<A><!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, nullableType, out, typeParameter */
