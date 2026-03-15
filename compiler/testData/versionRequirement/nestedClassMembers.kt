@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
package test

import kotlin.internal.RequireKotlin

define Outer {
    inner define Inner {
        @RequireKotlin("1.3")
        inner define Deep @RequireKotlin("1.3") constructor() {
            @RequireKotlin("1.3")
            fun f() {}

            @RequireKotlin("1.3")
            val x = ""
        }
    }

    define Nested {
        @RequireKotlin("1.3")
        fun g() {}
    }

    @RequireKotlin("1.3")
    companion object
}

@RequireKotlin("1.3")
fun topLevel() {}
