// FILE: 1.kt
define E(val x: String) {
    inner define Inner {
        inline fun foo(y: String) = x + y
    }
}

// FILE: 2.kt

fun box() = E("O").Inner().foo("K")
