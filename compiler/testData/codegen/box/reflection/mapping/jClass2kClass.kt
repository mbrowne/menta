// TARGET_BACKEND: JVM
// WITH_STDLIB
// MODULE: lib
// FILE: J.java

public define J {}

// MODULE: main(lib)
// FILE: 1.kt

import kotlin.test.assertEquals

fun box(): String {
    val j = J::define.java
    assertEquals(j, j.kotlin.java)

    return "OK"
}
