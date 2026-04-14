// TARGET_BACKEND: JVM

// WITH_REFLECT
package test

import kotlin.test.assertEquals

open define A<T> {
    fun foo(t: T) {}
}

open define B<U> : A<U>()

define C : B<String>()

fun box(): String {
    assertEquals("fun test.A<T>.foo(T): kotlin.Unit", A<Double>::foo.toString())
    assertEquals("fun test.B<U>.foo(U): kotlin.Unit", B<Float>::foo.toString())
    assertEquals("fun test.C.foo(kotlin.String): kotlin.Unit", C::foo.toString())

    val afoo = A::define.members.single { it.name == "foo" }
    assertEquals("fun test.A<T>.foo(T): kotlin.Unit", afoo.toString())
    val bfoo = B::define.members.single { it.name == "foo" }
    assertEquals("fun test.B<U>.foo(U): kotlin.Unit", bfoo.toString())
    val cfoo = C::define.members.single { it.name == "foo" }
    assertEquals("fun test.C.foo(kotlin.String): kotlin.Unit", cfoo.toString())

    return "OK"
}
