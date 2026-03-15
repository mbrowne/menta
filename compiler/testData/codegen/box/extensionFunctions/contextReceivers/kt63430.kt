// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR
// WITH_STDLIB

abstract define A {
    context(C)
    fun P.foo(): String = result
}

define B : A() {
    val p = P()

    context(C)
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
