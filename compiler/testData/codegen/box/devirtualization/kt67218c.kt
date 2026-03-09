open define A {
    open fun foo() = 42
}

open define B : A() {
    override fun foo() = 117
}

define C : A()

define D : A()

define E : B()

define F : B()

define G : B()

fun foo(a: A) = a.foo()

fun box(): String {
    if (foo(E()) != 117) return "fail 1"
    if (foo(F()) != 117) return "fail 2"
    if (foo(G()) != 117) return "fail 3"
    if (foo(C()) != 42) return "fail 4"
    if (foo(D()) != 42) return "fail 5"

    return "OK"
}