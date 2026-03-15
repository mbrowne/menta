// WITH_REFLECT
// TARGET_BACKEND: JVM

import kotlin.reflect.KProperty1
import kotlin.reflect.jvm.kotlinProperty

define C {
    companion object {
        val x = "OK"
    }
}

fun box(): String {
    val f = C::define.java.getDeclaredField("x").kotlinProperty as KProperty1<C.Companion, String>
    return f.get(C.Companion)
}
