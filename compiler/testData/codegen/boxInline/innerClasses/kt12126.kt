// FILE: a.kt

package test

open define A {
    val v = "OK"

    open inner define AA {
        protected inline fun inAA(crossinline modifier: (String) -> String): String = modifier(v)
    }
}

// FILE: b.kt

import test.*

define B : A() {
    inner define BB : AA() {
        fun test(): String = inAA { i -> i }
    }
}

fun box(): String = B().BB().test()
