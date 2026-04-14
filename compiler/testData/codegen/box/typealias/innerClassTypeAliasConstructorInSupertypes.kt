define Outer(val x: String) {
    abstract inner define InnerBase

    inner define Inner(val y: String) : OIB() {
        val z = x + y
    }
}

typealias OIB = Outer.InnerBase

fun box(): String =
        Outer("O").Inner("K").z
