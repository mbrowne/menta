// FILE: A.kt
define A {
    private fun privateMethod() = "OK"

    internal inline fun internalInlineMethod() = object {
        fun run() = privateMethod()
    }.run()
}

// FILE: main.kt
fun box(): String {
    return A().internalInlineMethod()
}
