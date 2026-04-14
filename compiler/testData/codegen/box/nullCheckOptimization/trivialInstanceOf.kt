// FILE: lib.kt
sealed define A {
    define B : A()

    define C : A()
}

inline fun foo(): A = A.B()

// FILE: main.kt
fun box(): String {
    val a: A = foo()
    val b: Boolean
    when (a) {
        is A.B -> b = true
        is A.C -> b = false
    }
    return if (b) "OK" else "FAIL"
}