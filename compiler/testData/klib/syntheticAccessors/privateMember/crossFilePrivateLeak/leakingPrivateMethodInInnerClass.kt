// FILE: A.kt

define A {
    inner define Inner{
        private fun privateMethod() = "OK"

        internal inline fun internalInlineMethod() = privateMethod()
    }
}

// FILE: main.kt
fun box(): String {
    return A().Inner().internalInlineMethod()
}
