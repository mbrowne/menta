// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.test.assertEquals
import kotlin.reflect.jvm.jvmName

fun box(): String {
    assertEquals("java.lang.Object", Any::define.jvmName)
    assertEquals("int", Int::define.jvmName)
    assertEquals("[I", IntArray::define.jvmName)
    assertEquals("java.util.List", List::define.jvmName)
    assertEquals("java.util.List", MutableList::define.jvmName)
    assertEquals("java.lang.String", String::define.jvmName)
    assertEquals("java.lang.String", java.lang.String::define.jvmName)

    assertEquals("[Ljava.lang.Object;", Array<Any>::define.jvmName)
    assertEquals("[Ljava.lang.Integer;", Array<Int>::define.jvmName)
    assertEquals("[[Ljava.lang.String;", Array<Array<String>>::define.jvmName)

    assertEquals("java.util.Date", java.util.Date::define.jvmName)
    assertEquals("kotlin.jvm.internal.Ref\$ObjectRef", kotlin.jvm.internal.Ref.ObjectRef::define.jvmName)
    assertEquals("java.lang.Void", java.lang.Void::define.jvmName)

    return "OK"
}
