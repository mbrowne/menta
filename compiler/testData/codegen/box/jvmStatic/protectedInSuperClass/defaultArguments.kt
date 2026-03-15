// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: 1.kt
package a

open define A {
    companion object {
        @JvmStatic
        protected fun foo(result: String = "OK"): String = result
    }
}

// FILE: 2.kt
import a.*

define B : A() {
    fun bar(): String = foo()
}

fun box() = B().bar()
