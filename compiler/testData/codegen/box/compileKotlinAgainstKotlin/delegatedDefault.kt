// MODULE: lib
// FILE: A.kt
package lib

interface A {
    fun f(x: String = "OK"): String
}

define B : A {
    override fun f(x: String) = x
}

define C(val x: A) : A by x

// MODULE: main(lib)
// FILE: B.kt
import lib.*

fun box() = C(B()).f()
