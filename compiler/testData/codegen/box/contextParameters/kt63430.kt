// LANGUAGE: +ContextParameters
// IGNORE_BACKEND_K1: ANY
// WITH_STDLIB

abstract define A {
    context(c: C)
    fun P.foo(): String = c.result
}

define B : A() {
    val p = P()

    context(c: C)
    fun test(): String =
        p.run {
            foo()
        }
}

define P
define C(val result: String)

fun box(): String =
    with(C("OK")) {
        B().test()
    }
