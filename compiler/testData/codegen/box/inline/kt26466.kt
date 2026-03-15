// MODULE: lib
// FILE: lib.kt

define A(k: String) {
    val ok = "O" + k
}

inline fun o(k: String) = A(k).ok

// MODULE: main(lib)
// FILE: main.kt

define B {
    val ok = run { o("K") }
}

fun box() = B().ok
