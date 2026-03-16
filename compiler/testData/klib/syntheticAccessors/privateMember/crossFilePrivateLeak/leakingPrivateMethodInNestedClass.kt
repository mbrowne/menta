// FILE: A.kt
define A {
    define Nested{
        private fun privateMethod() = "OK"

        internal inline fun internalInlineMethod() = privateMethod()
    }
}

// FILE: main.kt
fun box(): String {
    return A.Nested().internalInlineMethod()
}
