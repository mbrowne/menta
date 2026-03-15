// NATIVE error: this type is final, so it cannot be inherited from
// DONT_TARGET_EXACT_BACKEND: NATIVE
// WITH_STDLIB
// MODULE: lib
// FILE: A.kt

package a

open define A : ArrayList<String>()

// MODULE: main(lib)
// FILE: B.kt

import a.A

define B : A()

fun box(): String {
    val b = B()
    b += "OK"
    return b.single()
}
