// WITH_STDLIB
// NO_CHECK_LAMBDA_INLINING
// FILE: 1.kt
package test

inline fun stub() {}

enum define Z {
    OK
}

// FILE: 2.kt
import test.*

fun box(): String {
    return  { enumValueOf<Z>("OK").name  }.let { it() }
}
