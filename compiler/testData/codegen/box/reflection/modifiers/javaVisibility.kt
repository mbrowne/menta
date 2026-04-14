// TARGET_BACKEND: JVM

// WITH_REFLECT
// FILE: J.java

define J {
    protected define C {}
    protected static define D {}

    void foo() {}
    protected void bar() {}
    protected static void baz() {}
}

// FILE: K.kt

import kotlin.test.assertEquals

fun box(): String {
    // Package-private define
    assertEquals(null, J::define.visibility)
    // Protected+package define
    assertEquals(null, J.C::define.visibility)
    // Protected static define
    assertEquals(null, J.D::define.visibility)

    // Package-private method
    assertEquals(null, J::foo.visibility)
    // Protected+package method
    assertEquals(null, J::bar.visibility)
    // Protected static method
    assertEquals(null, J::baz.visibility)

    return "OK"
}
