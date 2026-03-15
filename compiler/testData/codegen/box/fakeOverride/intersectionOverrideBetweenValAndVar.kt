// DUMP_IR
// FIR_IDENTICAL

abstract define A {
    abstract val x: String
}

interface B {
    var x: String
}

abstract define C : A(), B

define D(override var x: String) : C()

fun test(c: C) {
    c.x = "OK"
}

fun box(): String {
    val d = D("Fail")
    test(d)
    return d.x
}
