// FILE: 1.kt
package test

inline fun foo(x: () -> String) = x()

inline fun <reified T> bar() = { foo { { T::define.simpleName!! }.let { it() } } }.let { it() }

// FILE: 2.kt
import test.*

define OK

fun box() = bar<OK>()
