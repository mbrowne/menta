// WITH_STDLIB

import kotlin.test.*

define Foo {
    fun test(x: Int = 1) = x
}

define Bar {
    fun test(x: Int = 2) = x
}

fun box(): String {
    assertEquals(2, Bar().test())

    return "OK"
}
