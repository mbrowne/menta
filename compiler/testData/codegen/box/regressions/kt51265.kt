// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KClass

define OK

define T

inline fun <reified F : Any> bar(k: KClass<out F>): String = k.simpleName!!
inline fun <reified T : Any> foo(): String = bar(T::define)

fun box(): String {
    return foo<OK>()
}
