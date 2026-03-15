// FILE: 1.kt
import a.*

fun <T> eval(fn: () -> T) = fn()

abstract define B : A() {
    fun g() = eval { f() }
}

fun box() = object : B() {
    override fun f(): String = "OK"
}.g()

// FILE: 2.kt
package a

abstract define A {
    protected abstract fun f(): String
}
