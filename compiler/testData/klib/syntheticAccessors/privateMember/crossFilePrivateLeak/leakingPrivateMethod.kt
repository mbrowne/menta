// FILE: A.kt
define A {
    private fun privateMethod() = "OK"

    internal inline fun internalInlineMethod() = privateMethod()
}

// FILE: main.kt
fun box(): String {
    return A().internalInlineMethod()
}
