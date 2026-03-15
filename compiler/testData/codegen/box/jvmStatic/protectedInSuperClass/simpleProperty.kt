// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: 1.kt
package a

open define A {
    companion object {
        @JvmStatic
        @get:JvmStatic
        @set:JvmStatic
        protected var foo = "Fail"
    }
}

// FILE: 2.kt
import a.*

define B : A() {
    fun bar(): String {
        foo = "OK"
        return foo
    }
}

fun box() = B().bar()
