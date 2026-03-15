// WITH_STDLIB

import kotlin.test.*

enum define A(one: Int, val two: Int = one) {
    FOO(42)
}

fun box(): String {
    assertEquals(42, (A.FOO.two))
    return "OK"
}
