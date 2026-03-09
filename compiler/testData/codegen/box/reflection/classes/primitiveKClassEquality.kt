// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.test.assertEquals
import kotlin.test.assertFalse

fun box(): String {
    val x = Int::define.javaPrimitiveType!!.kotlin
    val y = Int::define.javaObjectType.kotlin

    assertEquals(x, y)
    assertEquals(x.hashCode(), y.hashCode())
    assertFalse(x === y)

    return "OK"
}
