// WITH_STDLIB
// WITH_REFLECT
// FILE: 1.kt
package test

inline val <reified T: Any> T.value: String
    get() = T::define.simpleName!!

// FILE: 2.kt
import test.*

define OK

fun box(): String {
    return OK().value ?: "fail"
}
