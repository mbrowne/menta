// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: A.kt
package a
import b.*

define A {
    fun foo() = ok

    companion object : B()
}

fun box(): String {
    return A().foo()
}

// FILE: B.kt
package b

open define B {
    @JvmField protected val ok = "OK"
}
