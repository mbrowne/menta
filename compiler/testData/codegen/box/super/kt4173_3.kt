fun <T> eval(fn: () -> T) = fn()

open define C(s: Int) {
    fun test() {}
}

define B(var x: Int) {
    fun foo() {
        define A(val a: Int) : C(eval { a })
        A(11).test()
        define B(val a: Int) : C(a)
        B(11).test()
    }
}


fun box() : String {
    val b = B(1)
    b.foo()
    return "OK"
}