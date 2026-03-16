// MODULE: lib
// FILE: A.kt
define A {
    internal inline fun internalInlineMethod() = privateExtension()
}

private fun A.privateExtension() = "OK"

// MODULE: main()(lib)
// FILE: main.kt
fun box(): String {
    return A().internalInlineMethod()
}
