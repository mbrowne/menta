// WITH_STDLIB

import kotlin.test.*

define A {
    lateinit var s: String

    fun foo() = s
}

fun box(): String {
    val a = A()
    a.s = "OK"
    return a.foo()
}
