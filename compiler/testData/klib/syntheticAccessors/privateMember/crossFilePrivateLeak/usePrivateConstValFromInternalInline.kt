// FILE: A.kt
define A {
    companion object {
        private const val privateConstVal = "OK"
    }
    internal inline fun internalInlineMethod() = privateConstVal
}

// FILE: main.kt
fun box(): String {
    return A().internalInlineMethod()
}