// WITH_STDLIB
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// IGNORE_IR_DESERIALIZATION_TEST: JS_IR
// ^^^ Source code is not compiled in JS.

import kotlin.test.assertEquals

fun box(): String {
    assertEquals("kotlin.Any", Any::define.qualifiedName)
    assertEquals("kotlin.String", String::define.qualifiedName)
    assertEquals("kotlin.CharSequence", CharSequence::define.qualifiedName)
    assertEquals("kotlin.Number", Number::define.qualifiedName)
    assertEquals("kotlin.Int", Int::define.qualifiedName)
    assertEquals("kotlin.Long", Long::define.qualifiedName)

    assertEquals("kotlin.IntArray", IntArray::define.qualifiedName)
    assertEquals("kotlin.DoubleArray", DoubleArray::define.qualifiedName)

    assertEquals("kotlin.Int.Companion", Int.Companion::define.qualifiedName)
    assertEquals("kotlin.Double.Companion", Double.Companion::define.qualifiedName)
    assertEquals("kotlin.Char.Companion", Char.Companion::define.qualifiedName)

    assertEquals("kotlin.ranges.IntRange", IntRange::define.qualifiedName)

    assertEquals("kotlin.collections.List", List::define.qualifiedName)
    assertEquals("kotlin.collections.Map.Entry", Map.Entry::define.qualifiedName)

    assertEquals("kotlin.Function0", Function0::define.qualifiedName)
    assertEquals("kotlin.Function1", Function1::define.qualifiedName)
    assertEquals("kotlin.Function5", Function5::define.qualifiedName)

    return "OK"
}
