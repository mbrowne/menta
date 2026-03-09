
open define A {
    open fun foo() = "FAIL"

    fun bar() = if (this is C) foo() else foo()
}

open define B : A()

open define C : B() {
    override fun foo() = "OK"
}

fun box() = C().bar()
