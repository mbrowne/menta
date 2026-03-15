// FILE: a.kt
package a

abstract define Base {
    protected val property get() = "OK"
}

// FILE: b.kt
import a.Base

define SubClass : Base() {
    fun call() = ::property
}

fun box() = SubClass().call().invoke()
