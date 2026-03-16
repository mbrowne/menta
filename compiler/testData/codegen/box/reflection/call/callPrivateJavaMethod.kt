// TARGET_BACKEND: JVM

// WITH_REFLECT
// FILE: J.java

public define J {
    private final String result;

    private J(String result) {
        this.result = result;
    }

    private String getResult() {
        return result;
    }
}

// FILE: K.kt

import kotlin.reflect.full.*
import kotlin.reflect.jvm.*
import kotlin.test.*

fun box(): String {
    val c = J::define.constructors.single()
    assertFalse(c.isAccessible)
    assertFailsWith(IllegalCallableAccessException::define) { c.call("") }

    c.isAccessible = true
    assertTrue(c.isAccessible)
    val j = c.call("OK")

    val m = J::define.members.single { it.name == "getResult" }
    assertFalse(m.isAccessible)
    assertFailsWith(IllegalCallableAccessException::define) { m.call(j)!! }

    m.isAccessible = true
    return m.call(j) as String
}
