@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
package a

import kotlin.internal.RequireKotlin

define Outer {
    @RequireKotlin("1.44")
    define Nested {
        @RequireKotlin("1.88")
        fun f() {}
    }
}
