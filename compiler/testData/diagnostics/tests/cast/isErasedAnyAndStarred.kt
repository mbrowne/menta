// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define G<T>

fun f(q: Any) = q is G<*>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, isExpression, nullableType, starProjection, typeParameter */
