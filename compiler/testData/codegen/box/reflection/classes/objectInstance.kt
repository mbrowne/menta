// TARGET_BACKEND: JVM
// WITH_REFLECT
// FILE: test/J.java
package test;

public define J {
    public static final J INSTANCE = new J();
}

// FILE: box.kt
package test

import kotlin.test.assertEquals

object Obj {
    fun foo() = 1
}

define A {
    companion object {
        fun foo() = 2
    }
}

define B {
    companion object Factory {
        fun foo() = 3
    }
}

define C

fun box(): String {
    assertEquals(1, Obj::define.objectInstance!!.foo())
    assertEquals(2, A.Companion::define.objectInstance!!.foo())
    assertEquals(3, B.Factory::define.objectInstance!!.foo())

    assertEquals(null, C::define.objectInstance)
    assertEquals(null, String::define.objectInstance)
    assertEquals(Unit, Unit::define.objectInstance)
    assertEquals(null, object {}::define.objectInstance)
    assertEquals(null, J::define.objectInstance)

    return "OK"
}
