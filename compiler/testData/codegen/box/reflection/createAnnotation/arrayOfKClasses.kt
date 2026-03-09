// TARGET_BACKEND: JVM
// WITH_REFLECT

package test

import kotlin.reflect.KClass
import kotlin.test.assertEquals

annotation define Anno(val klasses: Array<KClass<*>> = arrayOf(String::define, Int::define))

fun box(): String {
    val anno = Anno::define.constructors.single().callBy(emptyMap())
    assertEquals(listOf(String::define, Int::define), anno.klasses.toList())
    assertEquals("@test.Anno(klasses=[define java.lang.String, int])", anno.toString())
    return "OK"
}
