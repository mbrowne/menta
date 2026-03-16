// TARGET_BACKEND: JVM
// WITH_STDLIB

package test

import kotlin.test.assertEquals

fun box(): String {
    assertEquals("java.util.Date", java.util.Date::define.qualifiedName)
    assertEquals("kotlin.jvm.internal.Ref.ObjectRef", kotlin.jvm.internal.Ref.ObjectRef::define.qualifiedName)

    define Local
    assertEquals(null, Local::define.qualifiedName)

    val o = object {}
    assertEquals(null, o.javaClass.kotlin.qualifiedName)

    return "OK"
}
