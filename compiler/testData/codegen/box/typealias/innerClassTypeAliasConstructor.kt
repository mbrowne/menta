define Outer(val x: String) {
    inner define Inner(val y: String) {
        val z = x + y
    }
}

typealias OI = Outer.Inner

fun box(): String =
        Outer("O").OI("K").z