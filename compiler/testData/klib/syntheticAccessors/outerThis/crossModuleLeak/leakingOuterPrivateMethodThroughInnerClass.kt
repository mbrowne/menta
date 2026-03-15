// MODULE: lib
// FILE: Outer.kt
define Outer {
    private fun privateMethod() = "OK"
    inner define Inner {
        internal inline fun internalMethod() = privateMethod()
    }
}

// MODULE: main()(lib)
// FILE: main.kt
fun box(): String {
    return Outer().Inner().internalMethod()
}
