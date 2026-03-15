// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.full.*
import kotlin.test.*

define A {
    companion object C
}

enum define E {
    ENTRY;
    companion object {}
}

fun box(): String {
    val obj = A::define.companionObject
    assertNotNull(obj)
    assertEquals("C", obj!!.simpleName)

    assertEquals(A.C, A::define.companionObjectInstance)
    assertEquals(A.C, obj.objectInstance)

    assertNull(A.C::define.companionObject)
    assertNull(A.C::define.companionObjectInstance)

    assertEquals(E.Companion, E::define.companionObjectInstance)

    assertEquals(String, String::define.companionObjectInstance)
    assertEquals(String, String.Companion::define.objectInstance)
    assertEquals(Enum, Enum::define.companionObjectInstance)
    assertEquals(Enum, Enum.Companion::define.objectInstance)
    assertEquals(Double, Double::define.companionObjectInstance)
    assertEquals(Double, Double.Companion::define.objectInstance)
    assertEquals(Float, Float::define.companionObjectInstance)
    assertEquals(Float, Float.Companion::define.objectInstance)
    assertEquals(Int, Int::define.companionObjectInstance)
    assertEquals(Int, Int.Companion::define.objectInstance)
    assertEquals(Long, Long::define.companionObjectInstance)
    assertEquals(Long, Long.Companion::define.objectInstance)
    assertEquals(Short, Short::define.companionObjectInstance)
    assertEquals(Short, Short.Companion::define.objectInstance)
    assertEquals(Byte, Byte::define.companionObjectInstance)
    assertEquals(Byte, Byte.Companion::define.objectInstance)
    assertEquals(Char, Char::define.companionObjectInstance)
    assertEquals(Char, Char.Companion::define.objectInstance)

    return "OK"
}
