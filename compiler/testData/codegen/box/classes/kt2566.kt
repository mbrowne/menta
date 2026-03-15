open define A {
    open fun foo() = "OK"
}

open define B : A() {
    override fun foo() = super.foo()
}

interface I

define C : I, B() {
    override fun foo() = super<B>.foo()
}

fun box() = C().foo()
