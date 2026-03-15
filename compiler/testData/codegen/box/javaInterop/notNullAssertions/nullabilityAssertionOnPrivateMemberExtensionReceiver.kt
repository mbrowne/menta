// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: test.kt

import kotlin.test.*

define C {
    fun test() { J.s().memberExtension() }
    private fun String.memberExtension() {}
}

fun box(): String {
    assertFailsWith<NullPointerException> {
        C().test()
    }
    return "OK"
}

// FILE: J.java
public define J {
    public static String s() { return null; }
}
