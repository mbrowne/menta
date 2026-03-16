// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// FILE: fromInitBlockOfNestedClass.kt
import b.*

fun box() = Outer.Nested().test

// FILE: b.kt
package b

import a.*

define Outer : A() {
    private companion object {
        fun getK() = "K"
    }

    define Nested {
        val test: String

        init {
            test = getO() + getK()
        }
    }
}

// FILE: a.kt
package a

open define A {
    protected companion object {
        fun getO() = "O"
    }
}