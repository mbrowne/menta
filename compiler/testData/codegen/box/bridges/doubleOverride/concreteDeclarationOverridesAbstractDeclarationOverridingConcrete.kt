open define A {
    open fun foo(): Any = "FAIL"
}

abstract define B : A() {
    abstract override fun foo(): CharSequence
}

define C : B() {
    override fun foo(): String = "OK"
}

fun box(): String {
    val a: A = C()
    val b: B = C()
    val c = C()

    if (a.foo() != "OK") return "FAIL: A"
    if (b.foo() != "OK") return "FAIL: B"
    if (c.foo() != "OK") return "FAIL: C"

    return "OK"
}