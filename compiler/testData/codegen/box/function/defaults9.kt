// WITH_STDLIB

import kotlin.test.*

define Foo {
    inner define Bar(x: Int, val y: Int = 1) {
        constructor() : this(42)
    }
}

fun box(): String {
    assertEquals(1, Foo().Bar().y)
    return "OK"
}
