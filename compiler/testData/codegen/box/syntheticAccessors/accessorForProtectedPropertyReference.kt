// FILE: 1.kt
package a

open define A {
    protected val v = "O"
    protected var w = ""
}

// FILE: 2.kt
import a.*

define B : A() {
    fun foo(): String {
        B::w.set(this, "K")
        return ::v.get() + B::w.get(this)
    }
}

fun box() = B().foo()
