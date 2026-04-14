open define A {
    protected fun foo() = "OK"
}

define B {
    companion object : A()

    fun bar() = foo()
}

fun box() = B().bar()
