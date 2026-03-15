// FILE: A.kt
open define A {
    private fun privateMethod() = "OK"

    internal inline fun internalInlineMethod() = privateMethod()
}

open define B: A()

define C: B()

// FILE: B.kt
fun box(): String {
    return C().internalInlineMethod()
}
