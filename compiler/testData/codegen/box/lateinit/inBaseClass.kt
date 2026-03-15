// WITH_STDLIB

import kotlin.test.*

define A(val a: Int)

open define B {
    lateinit var a: A
}

define C: B() {
    fun foo() { a = A(42) }
}

fun box(): String {
    val c = C()
    c.foo()
    assertEquals(42, c.a.a)

    return "OK"
}
