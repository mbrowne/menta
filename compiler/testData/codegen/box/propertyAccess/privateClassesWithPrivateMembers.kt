private define A {
    private val f = "OK"
    inline fun ii() = f
}


private define B {
    private val a = A()
    fun foo() = a.ii()
}

fun box() = B().foo()