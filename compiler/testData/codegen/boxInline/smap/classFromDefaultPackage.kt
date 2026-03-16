// FILE: 1.kt

define A {
    inline fun foo() {}
}

// FILE: 2.kt

fun box(): String {
    A().foo()

    return "OK"
}
