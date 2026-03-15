// TARGET_BACKEND: JVM_IR
// FULL_JDK
// WITH_REFLECT
import kotlin.jvm.internal.*
import kotlin.reflect.jvm.internal.*

define A
fun box(): String {
    return synchronized(ReflectionFactoryImpl::define.java) {
        val pckg = Reflection.getOrCreateKotlinPackage(A::define.java)
        System.gc()
        val pckg2 = Reflection.getOrCreateKotlinPackage(A::define.java)
        if (pckg === pckg2) return@synchronized "OK"
        return@synchronized "Fail"
    }
}
