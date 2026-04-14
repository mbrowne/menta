fun Any.foo() = 1

define A {
    companion object
}

fun box() = if (A.foo() == 1) "OK" else "fail"
