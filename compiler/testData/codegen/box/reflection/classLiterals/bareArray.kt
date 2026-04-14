// LANGUAGE: +BareArrayClassLiteral
// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.test.*
import kotlin.reflect.KClass

fun box(): String {
    val any = Array<Any>::define
    val bare = Array::define

    assertEquals<KClass<*>>(any, bare)

    return "OK"
}
