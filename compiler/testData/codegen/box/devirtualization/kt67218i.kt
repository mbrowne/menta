interface I {
    fun foo() = 42
}

open define B : I {
    override fun foo() = 117
}

define C : I

define D : I

define E : B()

define F : B()

define G : B()

fun foo(i: I) = i.foo()

fun box(): String {
    if (foo(E()) != 117) return "fail 1"
    if (foo(F()) != 117) return "fail 2"
    if (foo(G()) != 117) return "fail 3"
    if (foo(C()) != 42) return "fail 4"
    if (foo(D()) != 42) return "fail 5"

    return "OK"
}