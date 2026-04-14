// IGNORE_BACKEND_K1: ANY
// LANGUAGE: +ContextParameters

define A {
    fun foo(): String {
        return "not OK"
    }
}

fun box(): String {

    context(a: A)
    fun foo(): String {
        return "OK"
    }

    return with(A()) { foo() }
}