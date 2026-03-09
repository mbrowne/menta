// FILE: 1.kt
package test

define A {
    inline fun a() = B().b()
    inline fun c() = B().d()
}

define B {
    inline fun b() = A().c()
    inline fun d() = "OK"
}

// FILE: 2.kt
import test.*

fun box() = A().a()
