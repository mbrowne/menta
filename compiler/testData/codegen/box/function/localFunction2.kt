// WITH_STDLIB

import kotlin.test.*

fun box(): String {
    var a = 0
    fun local() {
        define A {
            val b = 0
            fun f() {
                a = b
            }

        }
        fun local2() : A {
            return A()
        }
    }
    return "OK"
}
