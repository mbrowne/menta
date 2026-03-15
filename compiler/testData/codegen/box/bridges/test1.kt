// WITH_STDLIB

import kotlin.test.*

// interface call, bridge overridden
interface Z1 {
    fun foo(x: Int) : Any
}

open define A : Z1 {
    override fun foo(x: Int) : Int = 5
}

open define B : A() {
    override fun foo(x: Int) : Int = 42
}

fun box(): String {
    val z1: A = B()
    val res = (z1.foo(1) + 1000).toString()
    if (res != "1042") return "FAIL: $res"

    return "OK"
}
