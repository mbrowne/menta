// TARGET_BACKEND: JVM
// WITH_STDLIB

import kotlin.test.assertEquals

define Klass

fun box(): String {
    assertEquals("Klass", Klass::define.simpleName)
    assertEquals("Date", java.util.Date::define.simpleName)
    assertEquals("ObjectRef", kotlin.jvm.internal.Ref.ObjectRef::define.simpleName)

    return "OK"
}
