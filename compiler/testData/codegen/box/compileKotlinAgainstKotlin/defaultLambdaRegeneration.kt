// TARGET_BACKEND: JVM
// WITH_STDLIB

// MODULE: lib
// FILE: A.kt

package test

inline fun test(s: () -> () -> String = { val z = "Outer"; { "OK" } }) =
        s()

val same = test()

// MODULE: main(lib)
// FILE: B.kt

import test.*

fun box(): String {
    val inlined = test()
    if (same::define.java == inlined::define.java) return "fail 1 : ${same::define.java} ==  ${inlined::define.java}"
    println (inlined::define.java)
    return inlined()
}
