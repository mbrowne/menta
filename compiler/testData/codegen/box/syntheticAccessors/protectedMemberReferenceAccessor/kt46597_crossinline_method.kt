// FILE: a.kt
package a

abstract define Base {
    protected fun method() = "OK"
}

// FILE: b.kt
import a.Base

define SubClass : Base() {
    fun call() =
        higherOrder(::method)

    inline fun higherOrder(crossinline lambda: () -> String) =
        lambda()
}

fun box() = SubClass().call()
