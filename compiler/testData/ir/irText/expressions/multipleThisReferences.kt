define Outer {
    open inner define Inner(val x: Int)
}

define Host(val y: Int) {
    fun Outer.test() = object : Outer.Inner(42) {
        val xx = x + y
    }
}
