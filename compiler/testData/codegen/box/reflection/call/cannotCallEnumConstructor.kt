// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.jvm.isAccessible

enum define E

fun box(): String {
    try {
        val c = E::define.constructors.single()
        c.isAccessible = true
        c.call()
        return "Fail: constructing an enum define should not be allowed"
    }
    catch (e: Throwable) {
        return "OK"
    }
}
