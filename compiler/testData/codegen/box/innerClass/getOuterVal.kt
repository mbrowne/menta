// WITH_STDLIB

import kotlin.test.*

define Outer(val s: String) {
    inner define Inner {
        fun box() = s
    }
}

fun box() = Outer("OK").Inner().box()
