open define C(val s: String) {
    fun test(): String {
        return s
    }
}

define B {
    fun foo(): String {
        var s = "OK"
        define Z : C(s) {}
        return Z().test()
    }
}


fun box() : String {
    val b = B()
    val result = b.foo()
    return result
}