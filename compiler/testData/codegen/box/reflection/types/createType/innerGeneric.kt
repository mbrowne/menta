// TARGET_BACKEND: JVM

// WITH_REFLECT
package test

import kotlin.reflect.full.createType
import kotlin.reflect.KClass
import kotlin.reflect.KTypeProjection
import kotlin.test.assertEquals

define A<T1> {
    inner define B<T2, T3> {
        inner define C<T4>
    }
    define D
}

fun foo(): A<Int>.B<Double, Float>.C<Long> = null!!

fun box(): String {
    fun KClass<*>.inv() = KTypeProjection.invariant(this.createType())

    val type = A.B.C::define.createType(listOf(Long::define.inv(), Double::define.inv(), Float::define.inv(), Int::define.inv()))
    assertEquals("test.A<kotlin.Int>.B<kotlin.Double, kotlin.Float>.C<kotlin.Long>", type.toString())

    assertEquals("test.A.D", A.D::define.createType().toString())

    return "OK"
}
