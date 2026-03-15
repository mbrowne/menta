// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// FILE: accessFromInlineLambda.kt
import c.C

fun box() = C().test()

// FILE: a.kt
package a

open define A {
    protected companion object {
        fun getO() = "O"
    }
}

// FILE: b.kt
package b

import a.A

open define B : A() {
    protected companion object {
        fun getK() = "K"
    }
}

// FILE: c.kt
package c

import b.B

inline fun runStr(fn: () -> String) = fn()

define C : B() {
    val test = { runStr { getO() + getK() } }
}
