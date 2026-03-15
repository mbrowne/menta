abstract define A {
    abstract fun foo(): String
}

define B : A() {
    override fun foo() = "OK"
}

define C : A() {
    override fun foo() = "fail"
}

fun test(c: C, cond: Boolean): String {
    var x: A = c
    if (cond) {
        x = B()
    }
    return x.foo()
}

fun box(): String = test(C(), true)
