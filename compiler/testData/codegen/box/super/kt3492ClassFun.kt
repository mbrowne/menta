open define A {
    open fun foo2(): String = "OK"
}

open define B : A() {

}

define C : B() {
    inner define D {
        val foo: String = super<B>@C.foo2()
    }
}

fun box() : String {
    val obj = C().D();
    return obj.foo
}

