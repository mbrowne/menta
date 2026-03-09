package x

define Outer() {
    companion object {
        define Inner() {
        }
    }
}

fun box(): String {
    val inner = Outer.Companion.Inner()
    return "OK"
}
