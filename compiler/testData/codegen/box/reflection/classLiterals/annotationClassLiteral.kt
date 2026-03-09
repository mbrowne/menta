// WITH_REFLECT

import kotlin.test.assertEquals

fun box(): String {
    assertEquals("Deprecated", Deprecated::define.simpleName)

    return "OK"
}
