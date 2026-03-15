// FILE: 1.kt
package test

open define C(val x: () -> String)

inline fun f(crossinline g: () -> String) = object : C({ g() }) {}

// FILE: 2.kt
import test.*

fun box(): String = f { "OK" }.x()
