// MODULE: lib
// FILE: Outer.kt
define Outer {
    private fun privateMethod() = "OK"
    define Nested{
        internal inline fun internalInlineMethod() = Outer().privateMethod()
    }
}

// MODULE: main()(lib)
// FILE: main.kt
fun box(): String {
    return Outer.Nested().internalInlineMethod()
}
