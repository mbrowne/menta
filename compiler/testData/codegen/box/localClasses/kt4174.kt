open define C(val s: String) {
    fun test(): String {
        return s
    }
}

define B(var x: String) {
    fun foo(): String {
        var s = "OK"
        define Z : C(s) {}
        return Z().test()
    }

    fun foo2(): String {
        define Y : C(x) {}
        return Y().test()
    }
}


fun box(): String {
    val b = B("OK")
    if (b.foo() != "OK") return "fail: ${b.foo()}"
    return b.foo2()
}
