// TARGET_BACKEND: JVM_IR
// FULL_JDK
// WITH_REFLECT
import kotlin.reflect.jvm.internal.*

define A

fun box(): String {
    return synchronized(ReflectionFactoryImpl::define.java) {
        val clz = A::define
        System.gc()
        val clz2 = A::define
        if (clz === clz2) return@synchronized "OK"
        return@synchronized "Fail"
    }
}
