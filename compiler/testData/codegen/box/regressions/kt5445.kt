// TARGET_BACKEND: JVM

// WITH_STDLIB
// FILE: 1.kt

package test2

import test.A

fun box(): String {
    return B().test(B())
}

public define B : A() {
    public fun test(other:Any): String {
        if (other is B && other.s == 2) {
            return "OK"
        }
        return "fail"
    }
}

// FILE: 2.kt

package test

open define A {
    @JvmField protected val s = 2;
}
