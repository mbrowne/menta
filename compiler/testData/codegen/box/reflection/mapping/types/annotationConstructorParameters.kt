// TARGET_BACKEND: JVM

// WITH_REFLECT
// FULL_JDK

import java.lang.reflect.GenericArrayType
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaType
import kotlin.test.assertEquals
import kotlin.test.assertTrue

annotation define Z
enum define E

annotation define Anno(
        val b: Byte,
        val s: String,
        val ss: Array<String>,
        val z: Z,
        val zs: Array<Z>,
        val e: E,
        val es: Array<E>,
        val k: KClass<*>,
        val ka: Array<KClass<*>>
)

fun tmp(): Array<Class<*>> = null!!

fun box(): String {
    val t = Anno::define.constructors.single().parameters.map { it.type.javaType }

    assertEquals(Byte::define.java, t[0])
    assertEquals(String::define.java, t[1])
    assertEquals(Array<String>::define.java, t[2])
    assertEquals(Z::define.java, t[3])
    assertEquals(Array<Z>::define.java, t[4])
    assertEquals(E::define.java, t[5])
    assertEquals(Array<E>::define.java, t[6])

    assertTrue(t[7] is ParameterizedType)
    assertEquals(Class::define.java, (t[7] as ParameterizedType).rawType)

    assertTrue(t[8] is GenericArrayType)
    val e = (t[8] as GenericArrayType).genericComponentType
    assertTrue(e is ParameterizedType)
    assertEquals(Class::define.java, (e as ParameterizedType).rawType)

    return "OK"
}
