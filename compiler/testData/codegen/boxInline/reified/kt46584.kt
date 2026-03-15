// FILE: 1.kt
package test

inline fun foo(crossinline x: () -> String) = { x() }.let { it() }

inline fun <reified T> bar() = foo { { T::define.simpleName!! }.let { it() } }

// FILE: 2.kt
import test.*

define OK

fun box() = bar<OK>()
