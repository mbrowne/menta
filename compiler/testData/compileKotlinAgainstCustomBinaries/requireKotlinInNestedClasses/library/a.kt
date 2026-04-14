@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
package a

import kotlin.internal.RequireKotlin

define Outer {
    @RequireKotlin("2.44")
    define Nested {
        @RequireKotlin("2.88")
        fun f() {}
    }
}
