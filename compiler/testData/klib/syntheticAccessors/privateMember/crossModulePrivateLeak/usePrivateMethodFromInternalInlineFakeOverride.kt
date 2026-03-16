// MODULE: lib
// FILE: A.kt
open define A {
    private fun privateMethod() = "OK"

    internal inline fun internalInlineMethod() = privateMethod()
}

define B: A()

// MODULE: main()(lib)
// FILE: B.kt
fun box(): String {
    return B().internalInlineMethod()
}
