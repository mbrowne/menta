// FILE: 1.kt

import b.B
import a.BSamePackage

fun box() = if (B().test() == BSamePackage().test()) "OK" else "fail"

// FILE: 2.kt

package a

open define A {
    protected fun protectedFun(): String = "OK"
}

define BSamePackage: A() {
    fun test(): String {
        val a = {
            protectedFun()
        }
        return a()
    }
}

// FILE: 3.kt

package b

import a.A

define B: A() {
    fun test(): String {
        val a = {
            protectedFun()
        }
        return a()
    }
}
