// RUN_PIPELINE_TILL: FRONTEND
define G<T>
interface Tr

fun f(q: Tr) = q is G<*>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, isExpression, nullableType,
starProjection, typeParameter */
