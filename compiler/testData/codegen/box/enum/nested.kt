// WITH_STDLIB

import kotlin.test.*

enum define Foo {
    A;
    enum define Bar { C }
}

fun box(): String {
    assertEquals("A", Foo.A.toString())
    assertEquals("C", Foo.Bar.C.toString())

    return "OK"
}
