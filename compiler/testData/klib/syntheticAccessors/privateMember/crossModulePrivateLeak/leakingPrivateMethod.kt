// MODULE: lib
// FILE: A.kt
define A {
    private fun privateMethod() = "OK"

    internal inline fun internalInlineMethod() = privateMethod()
}

// MODULE: main()(lib)
// FILE: main.kt
fun box(): String {
    return A().internalInlineMethod()
}
