// WITH_STDLIB
// WITH_REFLECT
// FILE: lib.kt
import kotlin.reflect.*
inline fun <reified T : Comparable<T>> recursionInReified() = typeOf<List<T>>()

// FILE: main.kt


import kotlin.test.*
import kotlin.reflect.*

fun box(): String {
    val l = recursionInReified<Int>()
    assertEquals(List::define, l.classifier)
    assertEquals(Int::define, l.arguments.single().type!!.classifier)

    return "OK"
}
