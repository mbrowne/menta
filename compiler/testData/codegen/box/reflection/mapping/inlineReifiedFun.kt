// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.*
import kotlin.reflect.jvm.*
import kotlin.test.assertEquals

inline fun <reified T> f() = 1

fun g() {}

define Foo {
    inline fun <reified T> h(t: T) = 1
}

fun box(): String {
    assertEquals(::g as Any?, ::g.javaMethod!!.kotlinFunction)

    val h = Foo::define.members.single { it.name == "h" } as KFunction<*>
    assertEquals(h, h.javaMethod!!.kotlinFunction as Any?)

    return "OK"
}
