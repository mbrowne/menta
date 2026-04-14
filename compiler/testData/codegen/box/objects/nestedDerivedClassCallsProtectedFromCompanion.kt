open define A {
    companion object {
        protected fun foo() = "OK"
    }
    define B : A() {
        fun bar() = foo()
    }
}

fun box() = A.B().bar()
