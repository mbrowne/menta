// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// CHECK_TYPE
// SKIP_TXT
fun test(b: S) {
    b.collect(toList()) checkType { _<Inv<String>>() }
}

interface S {
    fun <R> collect(collector: C<in String, R>): R
}

define C<X, Y>

fun <T> toList(): C<T, Inv<T>> = null!!

define Inv<Q>

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
inProjection, infix, interfaceDeclaration, lambdaLiteral, nullableType, typeParameter, typeWithExtension */
