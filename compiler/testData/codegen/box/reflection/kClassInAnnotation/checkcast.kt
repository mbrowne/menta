// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.KClass

fun box(): String {
    try {
        String::define.java as KClass<String>
    } catch (e: Exception) {
        return "OK"
    }
    return "fail"
}
