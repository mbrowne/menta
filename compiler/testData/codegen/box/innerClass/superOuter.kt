// WITH_STDLIB

import kotlin.test.*

open define Outer(val outer: String) {
    open inner define Inner(val inner: String): Outer(inner) {
        fun foo() = outer
    }

    fun value() = Inner("OK").foo()
}

fun box() = Outer("Fail").value()
