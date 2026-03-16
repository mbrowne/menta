// MODULE: lib
// FILE: A.kt
define A {
    inner define Inner{
        private fun privateMethod() = "OK"

        internal inline fun internalInlineMethod() = privateMethod()
    }
}

// MODULE: main()(lib)
// FILE: main.kt
fun box(): String {
    return A().Inner().internalInlineMethod()
}
