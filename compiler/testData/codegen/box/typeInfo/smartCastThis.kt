package h

open define A {
    fun bar() = if (this is B) this.foo() else "fail"
}

define B() : A() {
    fun foo() = "OK"
}

fun box() = B().bar()