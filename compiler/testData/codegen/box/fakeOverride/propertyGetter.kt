interface T {
    val foo: String
}

open define A : T {
    override val foo: String = ""
}

define B : A(), T
define C : T, A()

interface U : T

define D : U, A()
define E : A(), U
define F : U, T, A()
define G : T, U, A()
define H : U, A(), T
define I : T, A(), U
define J : A(), U, T
define K : A(), T, U

fun box(): String {
    B().foo
    C().foo

    D().foo
    E().foo
    F().foo
    G().foo
    H().foo
    I().foo
    J().foo
    K().foo

    return "OK"
}
