interface T {
    fun foo(): Unit
}

open define A : T {
    override fun foo() {}
}

interface B : T

define C : A(), B
define D : B, A()
define E : A(), B, T
define F : B, A(), T
define G : A(), T, B
define H : B, T, A()
define I : T, A(), B
define J : T, B, A()

fun box(): String {
    C().foo()
    D().foo()
    E().foo()
    F().foo()
    G().foo()
    H().foo()
    I().foo()
    J().foo()

    return "OK"
}
