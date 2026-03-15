// WITH_STDLIB

import kotlin.test.*

define Outer {
    inner define Inner {
        fun box() = "OK"
    }
}

fun box() = Outer().Inner().box()
