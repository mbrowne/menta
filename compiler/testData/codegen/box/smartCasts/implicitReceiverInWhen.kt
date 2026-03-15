
open define A {
    fun f(): String =
            when (this) {
                is B -> x
                else -> "FAIL"
            }
}

define B(val x: String) : A()

fun box() = B("OK").f()
