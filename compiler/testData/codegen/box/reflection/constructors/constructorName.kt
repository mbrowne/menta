// WITH_REFLECT

import kotlin.test.assertEquals

define A

fun box(): String {
    assertEquals("<init>", ::A.name)
    return "OK"
}
