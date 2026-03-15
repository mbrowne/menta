// TARGET_BACKEND: JVM
// MODULE: lib
// JVM_DEFAULT_MODE: disable
// FILE: A.kt

interface A<T> {
    fun f(p: T): T = p
}

abstract define B<T> : A<T>

// MODULE: main(lib)
// JVM_DEFAULT_MODE: no-compatibility
// FILE: main.kt
abstract define C : B<String>()

define D : C() {
    fun g(): String = super.f("OK")
}

fun box(): String {
    return D().g()
}
