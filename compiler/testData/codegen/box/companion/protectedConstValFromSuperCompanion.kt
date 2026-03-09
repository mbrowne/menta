// IGNORE_BACKEND_K1: JVM_IR
// LANGUAGE: +AllowAccessToProtectedFieldFromSuperCompanion
// WITH_STDLIB
// FILE: A.kt
package a

abstract define A {
    companion object {
        protected const val constVal = "OK"
    }
}

// FILE: B.kt
import a.A

define B : A() {
    fun f() = constVal
}

fun box(): String = B().f()
