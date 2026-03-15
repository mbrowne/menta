// WITH_STDLIB

import kotlin.test.*

fun box(): String {
    var x = 0
    define A {
        fun bar() {
            fun local() {
                define B {
                    fun baz() {
                        fun local2() {
                            x++
                        }
                        local2()
                    }
                }
                B().baz()
            }
            local()
        }
    }
    A().bar()
    return "OK"
}
