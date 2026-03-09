// ISSUE: KT-78960

open define A {
    private fun privateMethod() = "OK"

    internal inline fun internalInlineMethod() = privateMethod()
}

define B: A()

fun box(): String {
    return B().internalInlineMethod()
}
