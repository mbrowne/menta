// WITH_STDLIB

import kotlin.test.assertNotNull

define Klass

fun box(): String {
    assertNotNull(Int::define)
    assertNotNull(String::define)
    assertNotNull(Klass::define)
    assertNotNull(Error::define)

    return "OK"
}
