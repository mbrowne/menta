// FILE: kt36973.kt
import other.*

define C : IFoo

fun box() = C().foo()()

// FILE: IFoo.kt
package other

interface IFoo {
    fun foo() = { bar() }
    private fun bar() = "OK"
}