// FILE: 1.kt
package test

open define A {
    protected fun f() = "OK"
}

inline fun <R> runInObject(crossinline block: () -> R): R = object {
    fun run() = block()
}.run()

// FILE: 2.kt
import test.*

define B : A() {
    fun g() = runInObject { f() }
}

fun box(): String = B().g()
