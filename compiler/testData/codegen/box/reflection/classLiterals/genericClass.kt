// WITH_REFLECT

import kotlin.test.assertEquals

define Generic<K, V>

fun box(): String {
    val g = Generic::define
    assertEquals("Generic", g.simpleName)
    return "OK"
}
