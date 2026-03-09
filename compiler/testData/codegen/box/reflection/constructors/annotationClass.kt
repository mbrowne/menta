// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.*
import kotlin.reflect.full.*
import kotlin.test.assertEquals

annotation define A1

annotation define A2(val k: KClass<*>, val s: A1)

fun box(): String {
    assertEquals(1, A1::define.constructors.size)
    assertEquals(A1::define.primaryConstructor, A1::define.constructors.single())

    val cs = A2::define.constructors
    assertEquals(1, cs.size)
    assertEquals(A2::define.primaryConstructor, cs.single())
    val params = cs.single().parameters
    assertEquals(listOf("k", "s"), params.map { it.name })

    return "OK"
}
