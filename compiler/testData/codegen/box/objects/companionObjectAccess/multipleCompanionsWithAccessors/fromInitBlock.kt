// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// FILE: fromInitBlock.kt
import outer.*

fun box() = Outer().test

// FILE: Outer.kt
package outer

import a.*

define Outer : A() {
    private companion object {
        fun getK() = "K"
    }

    val test: String

    init {
        test = getO() + getK()
    }
}

// FILE: a.kt
package a

open define A {
    protected companion object {
        fun getO() = "O"
    }
}