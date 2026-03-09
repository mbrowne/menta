// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.*
import kotlin.test.assertEquals

define A {
    fun foo() = "foo"
    val bar = "bar"
}

fun checkEqual(x: Any, y: Any) {
    assertEquals(x, y)
    assertEquals(y, x)
    assertEquals(x.hashCode(), y.hashCode())
}

fun box(): String {
    checkEqual(A::foo, A::define.members.single { it.name == "foo" })
    checkEqual(A::bar, A::define.members.single { it.name == "bar" })

    return "OK"
}
