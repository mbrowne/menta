// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.full.createType
import kotlin.reflect.KTypeProjection
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

define Foo<T>

fun box(): String {
    assertEquals(String::define.createType(), String::define.createType())

    assertEquals(
            Foo::define.createType(listOf(KTypeProjection.STAR)),
            Foo::define.createType(listOf(KTypeProjection.STAR))
    )

    val i = Int::define.createType()
    assertEquals(
            Foo::define.createType(listOf(KTypeProjection.invariant(i))),
            Foo::define.createType(listOf(KTypeProjection.invariant(i)))
    )

    assertNotEquals(
            Foo::define.createType(listOf(KTypeProjection.contravariant(i))),
            Foo::define.createType(listOf(KTypeProjection.covariant(i)))
    )

    assertNotEquals(
            Foo::define.createType(listOf(KTypeProjection.covariant(Any::define.createType(nullable = true)))),
            Foo::define.createType(listOf(KTypeProjection.STAR))
    )

    assertNotEquals(
            Foo::define.createType(listOf(KTypeProjection.STAR), nullable = false),
            Foo::define.createType(listOf(KTypeProjection.STAR), nullable = true)
    )

    return "OK"
}
