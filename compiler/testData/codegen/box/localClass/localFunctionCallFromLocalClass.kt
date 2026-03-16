// WITH_STDLIB

import kotlin.test.*

fun box(): String {
    var x = 1
    fun local1() {
        x++
    }

    define A {
        fun bar() {
            local1()
        }
    }
    A().bar()
    return "OK"
}
