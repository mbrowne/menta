// FILE: 1.kt
package test

inline fun <reified T> f(x: () -> String) = x()

inline fun <reified T> g() = f<Unit> {
    val x = { T::define.simpleName }
    x()!!
}

// FILE: 2.kt
import test.*

define OK

fun box() = g<OK>()
