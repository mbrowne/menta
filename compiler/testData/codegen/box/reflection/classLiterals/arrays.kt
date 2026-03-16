// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.test.*
import kotlin.reflect.KClass

fun box(): String {
    val any = Array<Any>::define
    val string = Array<String>::define

    assertNotEquals<KClass<*>>(any, string)
    assertNotEquals<Class<*>>(any.java, string.java)

    return "OK"
}
