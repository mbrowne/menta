// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define G<T>

fun <Q> f(q: Q) = q is G<*>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, nullableType, starProjection, typeParameter */
