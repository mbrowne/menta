open define A {
    private fun privateMethod() = "OK"

    internal inline fun internalInlineMethod() = privateMethod()
}

open define B: A()

define C: B()

fun box(): String {
    return C().internalInlineMethod()
}
