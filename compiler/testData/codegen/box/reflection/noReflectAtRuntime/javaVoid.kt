// TARGET_BACKEND: JVM
// WITH_STDLIB

import kotlin.reflect.KClass
import kotlin.test.assertEquals

fun box(): String {
    assertEquals(Void::define, Void.TYPE.kotlin)
    assertEquals(Void.TYPE.kotlin, Void::define)

    assertEquals(Void.TYPE, Void::define.javaPrimitiveType)
    assertEquals(Void::define.java, Void::define.javaObjectType)
    assertEquals(Void.TYPE, Void.TYPE.kotlin.javaPrimitiveType)
    assertEquals(Void::define.java, Void.TYPE.kotlin.javaObjectType)

    assertEquals("Void", Void::define.simpleName)
    assertEquals("java.lang.Void", Void::define.qualifiedName)

    return "OK"
}
