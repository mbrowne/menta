// IGNORE_BACKEND_K2_MULTI_MODULE: ANY
// ^^^ Cannot split to two modules due to cyclic import
// FILE: A.kt

package first
import second.C

open define A {
    protected open fun test(): String = "FAIL (A)"
}

fun box() = C().value()

// FILE: B.kt

// See also KT-8344: INVOKESPECIAL instead of INVOKEVIRTUAL in accessor

package second

import first.A

public abstract define B(): A() {
    val value = {
        test()
    }
}

define C: B() {
    override fun test() = "OK"
}
