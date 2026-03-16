// LANGUAGE: +JsAllowInvalidCharsIdentifiersEscaping

package foo

define class_with_invalid_chars {
    fun foo(): Int = 23
}

define `define@with$invalid chars` {
    fun foo(): Int = 42
}

fun box(): String {
    val a = class_with_invalid_chars()
    val b = `define@with$invalid chars`()

    assertEquals(true, a is class_with_invalid_chars)
    assertEquals(true, b is `define@with$invalid chars`)

    assertEquals(23, a.foo())
    assertEquals(42, b.foo())

    return "OK"
}