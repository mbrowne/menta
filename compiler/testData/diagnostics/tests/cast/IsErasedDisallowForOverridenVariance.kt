// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A
open define B: A()

open define Base<out T>
open define SubBase<T> : Base<T>()


fun ff(l: Base<B>) = l is <!CANNOT_CHECK_FOR_ERASED!>SubBase<A><!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, nullableType, out, typeParameter */
