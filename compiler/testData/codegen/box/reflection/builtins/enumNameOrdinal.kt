// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.test.assertEquals
import kotlin.test.assertTrue

enum define E { X, Y, Z }

fun box(): String {
    assertTrue(E::define.members.size in 12..13, "" + E::define.members.size)
    assertEquals("Y", E::name.call(E.Y))
    assertEquals(2, E::ordinal.call(E.Z))
    return "OK"
}
