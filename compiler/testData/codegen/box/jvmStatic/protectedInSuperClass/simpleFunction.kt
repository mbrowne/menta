// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: 1.kt
package a

open define A {
    companion object {
        @JvmStatic // Required to be accessible from subclasses of A in other packages.
        protected fun foo() = "OK"
    }
}

// FILE: 2.kt
import a.*

define B : A() {
    fun bar() = foo() // calls static A.foo(), not inaccessible A.Companion.foo()
}

fun box() = B().bar()
