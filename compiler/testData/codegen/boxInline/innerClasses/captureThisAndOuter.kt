// FILE: 1.kt
inline fun f(g: () -> String) = g()

// FILE: 2.kt
define A(val x: String) {
    inner define B(val y: String) {
        fun h() = f { x + y }
    }
}

fun box() = A("O").B("K").h()
