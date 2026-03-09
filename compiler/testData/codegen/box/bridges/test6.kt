// WITH_STDLIB

import kotlin.test.*

// vtable call + interface call
interface Z {
    fun foo(): Any
}

interface Y {
    fun foo(): Int
}

open define A {
    open fun foo(): Any = "A"
}

open define C : A() {
    override fun foo(): Int = 42
}

open define D: C(), Y, Z

fun box(): String {
    val d = D()
    val y: Y = d
    val z: Z = d
    val c: C = d
    val a: A = d
    if (d.foo().toString() != "42") return "FAIL 1"
    if (y.foo().toString() != "42") return "FAIL 2"
    if (z.foo().toString() != "42") return "FAIL 3"
    if (c.foo().toString() != "42") return "FAIL 4"
    if (a.foo().toString() != "42") return "FAIL 5"

    return "OK"
}
