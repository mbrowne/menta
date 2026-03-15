// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define A
open define B: A()

open define Base<in T>
define SubBase: Base<A>()

// f is SubBase => f is Base<A> => (Base<Contravariant T>, B <: A) f is Base<B>
fun test(f: SubBase) = <!USELESS_IS_CHECK!>f is Base<B><!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, isExpression, nullableType, typeParameter */
