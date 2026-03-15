// TARGET_BACKEND: JVM

// WITH_REFLECT

package test

import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.reflect.jvm.jvmName

define Klass {
    define Nested
    companion object
}

fun box(): String {
    assertEquals("test.Klass", Klass::define.jvmName)
    assertEquals("test.Klass\$Nested", Klass.Nested::define.jvmName)
    assertEquals("test.Klass\$Companion", Klass.Companion::define.jvmName)

    define Local
    val l = Local::define.jvmName
    assertTrue(l != null && l.startsWith("test.JvmNameKt\$") && "\$box\$" in l && l.endsWith("\$Local"))

    val obj = object {}
    val o = obj.javaClass.kotlin.jvmName
    assertTrue(o != null && o.startsWith("test.JvmNameKt\$") && "\$box\$" in o && o.endsWith("\$1"))

    return "OK"
}
