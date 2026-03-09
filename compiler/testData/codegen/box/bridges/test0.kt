// WITH_STDLIB

import kotlin.test.*

// vtable call
open define A {
    open fun foo(): Any = "A"
}

open define C : A() {
    override fun foo(): Int = 42
}

fun box(): String {
    val c = C()
    val a: A = c
    val res1 = c.foo().toString()
    if (res1 != "42") return "FAIL 1: $res1"
    val res2 = a.foo().toString()
    if (res2 != "42") return "FAIL 2: $res2"

    return "OK"
}
