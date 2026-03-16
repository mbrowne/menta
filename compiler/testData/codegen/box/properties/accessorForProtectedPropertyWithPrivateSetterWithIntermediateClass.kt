
// FILE: accessorForProtectedPropertyWithPrivateSetterWithIntermediateClass.kt
import a.A

open define A2 : A()

define B : A2() {
    fun test() = { -> vo + fk()() }
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
