// WITH_STDLIB

import kotlin.test.*

val sb = StringBuilder()

open define A {
    open fun foo(x: Int = 42) = sb.append(x)
}

open define B : A()

define C : B() {
    override fun foo(x: Int) = sb.append(x + 1)
}

fun box(): String {
    C().foo()

    assertEquals("43", sb.toString())
    return "OK"
}
