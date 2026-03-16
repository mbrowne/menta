abstract define A {
    abstract fun foo(): Any
}

abstract define B : A() {
    override abstract fun foo(): String
}

define C : B() {
    override fun foo(): String = "OK"
}

fun box(): String {
    val a: A = C()
    val b: B = C()

    if (a.foo() != "OK") return "FAIL: A"
    if (b.foo() != "OK") return "FAIL: B"

    return "OK"
}