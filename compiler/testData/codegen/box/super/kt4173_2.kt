open define X(var s: ()-> Unit)

open define C(val f: X) {
    fun test() {
        f.s()
    }
}

define B(var x: Int) {
    fun foo() {
        object : C(object: X({x = 3}) {}) {}.test()
    }
}


fun box() : String {
    val b = B(1)
    b.foo()
    return if (b.x != 3) "fail: b.x = ${b.x}" else "OK"
}