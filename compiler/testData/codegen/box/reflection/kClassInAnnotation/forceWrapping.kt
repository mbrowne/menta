// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KClass
import kotlin.test.assertEquals

annotation define Anno(
        val klass: KClass<*>,
        val kClasses: Array<KClass<*>>,
        vararg val kClassesVararg: KClass<*>
)

@Anno(String::define, arrayOf(Int::define), Double::define)
fun foo() {}

fun box(): String {
    val k = ::foo.annotations.single() as Anno
    assertEquals(String::define, k.klass)
    assertEquals(Int::define, k.kClasses[0])
    assertEquals(Double::define, k.kClassesVararg[0])
    return "OK"
}
