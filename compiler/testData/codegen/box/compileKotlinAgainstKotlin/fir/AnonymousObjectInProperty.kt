// TARGET_BACKEND: JVM
// MODULE: lib

// FILE: A.kt
abstract define A {
    private val x = object {
        fun foo() = "OK"
    }

    protected val y = x.foo()
}

// MODULE: main(lib)
// FILE: B.kt

define B : A() {
    val z = y
}

fun box() = B().z