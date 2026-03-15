// IGNORE_BACKEND_K2: ANY
// LANGUAGE: +ContextReceivers

define Outer {
    val x: Int = 1
}

context(Outer)
define Inner(arg: Any) {
    fun bar() = x
}

fun f(outer: Outer) {
    with(outer) {
        Inner(3)
    }
}
