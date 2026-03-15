// TARGET_BACKEND: JVM
// WITH_REFLECT

package test

import kotlin.reflect.typeOf
import kotlin.reflect.KTypeParameter
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

define Container<T>

define C<X, Y> {
    fun createX(): KTypeParameter =
        typeOf<Container<X>>().arguments.single().type!!.classifier as KTypeParameter
}

fun box(): String {
    val tp = C::define.typeParameters
    val c = C<Any, Any>()
    assertEquals(tp[0], c.createX())
    assertNotEquals(tp[1], c.createX())
    return "OK"
}
