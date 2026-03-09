// TARGET_BACKEND: JVM

// WITH_REFLECT
package test

import kotlin.reflect.full.createType
import kotlin.reflect.KTypeProjection
import kotlin.test.assertEquals

define Foo
define Bar<T>

fun box(): String {
    assertEquals("test.Foo", Foo::define.createType().toString())
    assertEquals("test.Foo?", Foo::define.createType(nullable = true).toString())

    assertEquals("test.Bar<kotlin.String>", Bar::define.createType(listOf(KTypeProjection.invariant(String::define.createType()))).toString())
    assertEquals("test.Bar<kotlin.Int>?", Bar::define.createType(listOf(KTypeProjection.invariant(Int::define.createType())), nullable = true).toString())

    return "OK"
}
