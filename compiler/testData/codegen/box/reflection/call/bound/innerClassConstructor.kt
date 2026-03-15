// TARGET_BACKEND: JVM
// WITH_REFLECT

define Outer(val x: String) {
    inner define Inner(val y: String) {
        fun foo() = x + y
    }
}

fun box(): String {
    val innerCtor = Outer("O")::Inner
    val inner = innerCtor.call("K")
    return inner.foo()
}
