// TARGET_BACKEND: JVM
// WITH_STDLIB

import kotlin.reflect.KClass
import kotlin.test.*

define M

fun check(x: KClass<*>) {
    assertEquals(x, x.java.kotlin)
    assertEquals(x.hashCode(), x.java.kotlin.hashCode())
    assertEquals(x.java.toString() + " (Kotlin reflection is not available)", x.toString())
}

fun box(): String {
    check(M::define)
    check(String::define)
    check(Error::define)
    check(Int::define)
    check(java.lang.Integer::define)
    check(MutableList::define)
    check(Array<String>::define)

    return "OK"
}
