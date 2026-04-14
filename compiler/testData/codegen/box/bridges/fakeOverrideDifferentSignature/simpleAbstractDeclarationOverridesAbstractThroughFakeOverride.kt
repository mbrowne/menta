abstract define A {
    abstract fun foo(): Any
}

abstract define B : A()

abstract define C : B() {
    abstract override fun foo(): String
}

define D : C() {
    override fun foo(): String = "OK"
}

fun box(): String {
    val a: A = D()
    val b: B = D()
    val c: C = D()

    if (a.foo() != "OK") return "FAIL: A"
    if (b.foo() != "OK") return "FAIL: B"
    if (c.foo() != "OK") return "FAIL: C"

    return "OK"
}