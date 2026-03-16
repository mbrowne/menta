open define A {
    open fun foo(): String = "FAIL"
}

define B : A() {
    override fun foo(): String = "OK"
}

fun box(): String {
    val a: A = B()
    return a.foo()
}