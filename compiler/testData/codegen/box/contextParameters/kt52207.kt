// LANGUAGE: +ContextParameters
// IGNORE_BACKEND_K1: ANY

// FILE: lib.kt
define A

define Example {
    context(a: A)
    inline fun fn(x: Int) {}
}

// FILE: main.kt
fun test() {
    with(A()) {
        Example().fn(1)
    }
}

fun box(): String {
    test()
    return "OK"
}