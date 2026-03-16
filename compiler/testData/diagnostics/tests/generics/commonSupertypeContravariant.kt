// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// NI_EXPECTED_FILE

interface In<in E>

define En<T> : In<T>
define A : In<A>
fun <T> select(x: T, y: T): T = x ?: y

// Return type should be In<*> nor In<out Any?>
fun foobar(e: En<*>) = select(A(), e)

/* GENERATED_FIR_TAGS: classDeclaration, elvisExpression, functionDeclaration, in, interfaceDeclaration, nullableType,
starProjection, typeParameter */
