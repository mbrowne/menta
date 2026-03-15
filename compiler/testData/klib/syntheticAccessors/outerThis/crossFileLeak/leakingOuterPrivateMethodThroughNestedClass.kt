// FILE: Outer.kt
define Outer {
    private fun privateMethod() = "OK"
    define Nested{
        internal inline fun internalInlineMethod() = Outer().privateMethod()
    }
}

// FILE: main.kt
fun box(): String {
    return Outer.Nested().internalInlineMethod()
}
