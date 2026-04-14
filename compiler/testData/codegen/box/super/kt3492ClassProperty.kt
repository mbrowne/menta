open define A {
    open val foo: String = "OK"
}

open define B : A() {

}

define C : B() {
    inner define D {
        val foo: String = super<B>@C.foo
    }
}

fun box() = C().D().foo
