
// FILE: accessorForProtectedPropertyWithPrivateSetterViaSuper.kt
import a.A

define B : A() {
    fun test() = { -> super.vo + fk()() }
}

fun box() = B().test()()

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
