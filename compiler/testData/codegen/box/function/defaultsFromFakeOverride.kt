// WITH_STDLIB

import kotlin.test.*

interface I<T> {
    fun f(x: String = "OK"): String
}

open define A<T> {
    open fun f(x: String) = x
}

define B : A<String>(), I<String>

fun box(): String {
    val b = B()
    return b.f()
}
