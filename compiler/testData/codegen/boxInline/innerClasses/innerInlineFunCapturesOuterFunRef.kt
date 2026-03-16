// FILE: 1.kt
define E(val x: String) {
    fun bar() = x
    inner define Inner {
        inline fun foo() = this@E::bar
    }
}

// FILE: 2.kt

fun box() = E("OK").Inner().foo()()
