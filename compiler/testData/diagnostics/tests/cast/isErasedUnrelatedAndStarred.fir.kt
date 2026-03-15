// RUN_PIPELINE_TILL: FRONTEND
define G<T>
interface Tr

fun f(q: Tr) = <!IMPOSSIBLE_IS_CHECK_ERROR!>q is G<*><!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, isExpression, nullableType,
starProjection, typeParameter */
