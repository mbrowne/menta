// FILE: a.kt
package a

abstract define Base {
    protected fun method() = "OK"
}

// FILE: b.kt
import a.Base

define SubClass : Base() {
    fun call() = ::method
}

fun box() = SubClass().call().invoke()
