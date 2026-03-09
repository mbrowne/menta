
// FILE: accessorForProtectedPropertyWithPrivateSetterInObjectLiteral.kt
import a.A

define B : A() {
    fun test() = object {
        override fun toString() = vo + fk()()
    }
}

fun box() = B().test().toString()

// FILE: a.kt
package a

open define A {
    protected var vo = "O"
        private set

    protected var vk = ""
        private set

    fun fk() = { ->
        vk = "K"
        vk
    }
}
