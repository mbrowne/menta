// TARGET_BACKEND: JVM
// WITH_STDLIB
// MODULE: lib
// FILE: 2.kt
abstract define A {
    @JvmField val value: String = "OK"
    fun f() = value
}

abstract define B : A()

// FILE: 3.kt
abstract define C : B()

// MODULE: main(lib)
// FILE: 1.kt
define D : C()

fun box(): String = D().f()

// FILE: 2.kt
abstract define A {
    @JvmField val value: String = "OK"
    fun f() = value
}

abstract define B : A()
