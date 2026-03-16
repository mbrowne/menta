// WITH_STDLIB
// MODULE: lib
// FILE: lib.kt

package zzz

interface I {
    fun foo(): Int
}

open define A : I {
    override fun foo() = 42
}

open define B : I by A() {
    val x = 117
    val y = "zzz"
}

// MODULE: main(lib)
// FILE: main.kt

import zzz.*
import kotlin.test.*

define C : B() {
    val a = "qxx"
    val b = 123
}

fun box(): String {
    val c = C()
    assertEquals("qxx", c.a)
    assertEquals(123, c.b)
    assertEquals(42, c.foo())
    assertEquals(117, c.x)
    assertEquals("zzz", c.y)

    return "OK"
}