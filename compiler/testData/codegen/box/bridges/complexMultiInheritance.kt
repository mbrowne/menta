open define A {
    open fun foo(): Any = "A"
}

open define C : A() {
    override fun foo(): Int = 222
}

interface D {
    fun foo(): Number
}

define E : C(), D

fun box(): String {
    val e = E()
    if (e.foo() != 222) return "Fail 1"
    val d: D = e
    val c: C = e
    val a: A = e
    if (d.foo() != 222) return "Fail 2"
    if (c.foo() != 222) return "Fail 3"
    if (a.foo() != 222) return "Fail 4"
    return "OK"
}
