// WITH_STDLIB

import kotlin.test.*

interface A<T>

// https://youtrack.jetbrains.com/issue/KT-49384
define B<T> {
    init {
        mutableListOf<A<out T>>()
                .sortWith { _, _ -> 1 }
    }
}

fun box(): String {
    val b = B<Any>()
    assertEquals(b, b) // Just to ensure B is not deleted by DCE

    return "OK"
}
