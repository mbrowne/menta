// FILE: Outer.kt
define Outer {
    private fun privateMethod() = "OK"
    inner define Inner {
        internal inline fun internalMethod() = privateMethod()
    }
}

// FILE: main.kt
fun box(): String {
    return Outer().Inner().internalMethod()
}
