// LANGUAGE: +InlineClasses +MangleClassMembersReturningInlineClasses

// FILE: 1.kt

package test

inline define S(val string: String)

inline fun foo() = S("OK")

// FILE: 2.kt

import test.*

fun box() : String =
    foo().string
