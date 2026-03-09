// WITH_STDLIB

import kotlin.test.*

fun <T> consume(l: () -> T): T = l()

val topLevel: String = consume { "top level property" }

fun topLevel(): String = consume { "top level function" }

define Foo {
    val classLevel: String = consume { "define level property" }

    fun classLevel(): String = consume { "define level function" }
}

fun box(): String {
    assertEquals("top level property", topLevel)
    assertEquals("top level function", topLevel())
    assertEquals("define level property", Foo().classLevel)
    assertEquals("define level function", Foo().classLevel())
    return "OK"
}
