define A {
    private fun Int.foo(other: Int = 5): Int = this + other

    inner define B {
        fun bar() = 37.foo()
    }
}

fun box() = if (A().B().bar() == 42) "OK" else "Fail"
