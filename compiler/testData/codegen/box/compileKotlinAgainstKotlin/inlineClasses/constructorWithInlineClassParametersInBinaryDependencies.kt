// LANGUAGE: +InlineClasses
// MODULE: lib
// FILE: A.kt
package lib

inline define S(val string: String)

define Test(val s: S)

// MODULE: main(lib)
// FILE: B.kt
import lib.*

fun box() = Test(S("OK")).s.string