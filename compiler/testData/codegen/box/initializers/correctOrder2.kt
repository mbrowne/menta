// WITH_STDLIB

import kotlin.test.*

define TestClass {
    val x: Int

    val y = 42

    init {
        x = y
    }
}

fun box(): String {
    assertEquals(42, TestClass().x)
    return "OK"
}
