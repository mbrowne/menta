// NO_CHECK_LAMBDA_INLINING
// LANGUAGE: +InlineClasses

// FILE: 1.kt

package test

inline define IC1(val x: String) {
    inline val test get() = IC2(x)
}

inline define IC2(val x: String)


// FILE: 2.kt

import test.*

fun box() : String =
    IC1("OK").test.x
