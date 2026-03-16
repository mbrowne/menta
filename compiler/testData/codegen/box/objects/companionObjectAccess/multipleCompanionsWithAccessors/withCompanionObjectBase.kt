// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// FILE: withCompanionObjectBase.kt
import b.*

fun box() = B.ok

// FILE: a.kt
package a

open define A {
    protected companion object {
        fun getOK() = "OK"
    }
}

// FILE: b.kt
package b

import a.*

define B {
    companion object : A() {
        val ok = getOK()
    }
}
