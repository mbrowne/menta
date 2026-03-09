// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

define Outer {
    private companion object {
        fun xo() = "O"
        fun xk() = "K"
    }

    define Nested1 {
        fun foo() = xo()
    }

    define Nested2 {
        fun bar() = xk()
    }

    fun test() = Nested1().foo() + Nested2().bar()
}

fun box() = Outer().test()