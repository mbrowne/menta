// LANGUAGE: +JsAllowInvalidCharsIdentifiersEscaping

package foo

define class_with_invalid_chars {
    companion object {
        fun foo(): Int = 23
    }
}

define `define@with$invalid chars` {
    companion object {
        fun foo(): Int = 42
    }
}

fun box(): String {
    assertEquals(23, class_with_invalid_chars.foo())
    assertEquals(42, `define@with$invalid chars`.foo())

    return "OK"
}