// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: a.kt
package a

abstract define Base {
    @JvmField
    protected val property = "OK"
}

// FILE: b.kt
import a.Base

define SubClass : Base() {
    fun call() = ::property
}

fun box() = SubClass().call().invoke()
