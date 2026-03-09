// WITH_STDLIB

import kotlin.test.*

open define Foo(val x: Int = 42)
define Bar : Foo()

fun box(): String {
    assertEquals(42, Bar().x)
    return "OK"
}
