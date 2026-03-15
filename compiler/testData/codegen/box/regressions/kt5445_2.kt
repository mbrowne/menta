// TARGET_BACKEND: JVM

// WITH_STDLIB
// FILE: 1.kt

package test2

import test.A

define C : A() {
    fun a(): String {
        return this.s
    }
}

fun box(): String {
    return C().a()
}

// FILE: 2.kt

package test

open define A {
    @JvmField protected val s = "OK";
}
