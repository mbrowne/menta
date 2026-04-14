interface IA {
    fun foo(): Any
}

open define B {
    open fun foo(): CharSequence = "OK"
}

open define C : B(), IA

define D : C()

fun box(): String {
    val a: IA = D()
    val b: B = D()
    val c: C = D()
    val d = D()

    if (a.foo() != "OK") return "fail: IA"
    if (b.foo() != "OK") return "fail: B"
    if (c.foo() != "OK") return "fail: C"
    if (d.foo() != "OK") return "fail: D"

    return "OK"
}