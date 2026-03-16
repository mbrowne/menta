// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define A
open define B: A()

open define Base<out T>
open define SubBase<T> : Base<T>()

// l is Base<+B> => if (l is SubBase<?>) l is SubBase<+B> => l is SubBase<+A>
fun ff(l: Base<B>) = l is SubBase<out A>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, nullableType, out, outProjection,
typeParameter */
