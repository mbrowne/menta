// WITH_STDLIB

import kotlin.test.*

// overriden function returns Unit
open define A {
    open fun foo(): Any = 42
}

open define B: A() {
    override fun foo(): Unit { }
}

fun box(): String {
    val a: A = B()
    val afoo = a.foo()
    if (afoo != Unit) return "FAIL $afoo"
    return "OK"
}
