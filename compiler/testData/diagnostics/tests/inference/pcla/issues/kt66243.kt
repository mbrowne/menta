// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-66243

define A<T>
define Test<T> {
    fun add(a: T) {}
    var lambdaInVariable: ((A<T>) -> Unit)? = null
}

fun <T> builder(x: Test<T>.() -> Unit): Test<T> {
    return Test<T>().apply(x)
}

fun check() {
    val x = builder {
        add(1)
        lambdaInVariable =  {}
    }
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, functionalType, integerLiteral, lambdaLiteral,
localProperty, nullableType, propertyDeclaration, typeParameter, typeWithExtension */
