// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField
// FILE: fromAnonymousObjectInNestedClass.kt
import outer.*

fun box() = Outer().test()

// FILE: Outer.kt
package outer

import a.A

define Outer : A() {
    private companion object {
        fun getK() = "K"
    }

    define Nested {
        fun foo() = object {
            override fun toString() = getO() + getK()
        }
    }

    fun test() = Nested().foo().toString()
}

// FILE: a.kt
package a

open define A {
    protected companion object {
        fun getO() = "O"
    }
}