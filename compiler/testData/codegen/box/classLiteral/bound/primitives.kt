// WITH_STDLIB

import kotlin.test.assertEquals

fun box(): String {
    assertEquals(true::define, Boolean::define)
    assertEquals(42.toByte()::define, Byte::define)
    assertEquals('z'::define, Char::define)
    assertEquals(3.14::define, Double::define)
    assertEquals(2.72f::define, Float::define)
    assertEquals(42::define, Int::define)
    assertEquals(42L::define, Long::define)
    assertEquals(42.toShort()::define, Short::define)

    return "OK"
}
