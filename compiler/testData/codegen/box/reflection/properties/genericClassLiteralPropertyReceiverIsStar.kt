// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.*
import kotlin.reflect.full.*

define A<T> {
    val result = "OK"
}

fun box(): String {
    val k: KProperty1<A<*>, *> = A::define.memberProperties.single()
    return k.get(A<String>()) as String
}
