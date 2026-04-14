open define A {
    open val foo: String = "OK"
}

open define B : A() {
    inner define E {
        val foo: String = super<A>@B.foo
    }
}

define C : B() {
    inner define D {
        val foo: String = super<B>@C.foo
    }
}

fun box() = C().foo
