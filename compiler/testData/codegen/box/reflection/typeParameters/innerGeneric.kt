// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KVariance
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

define A<out T> {
    inner define B<in U> {
        fun test(u: U): T? = null
    }
}

fun box(): String {
    val fn = A.B::define.members.single { it.name == "test" }

    val t = A::define.typeParameters.single()
    val u = A.B::define.typeParameters.single()

    assertEquals("T", t.name)
    assertEquals(KVariance.OUT, t.variance)
    assertEquals(false, t.isReified)
    assertEquals("U", u.name)
    assertEquals(KVariance.IN, u.variance)
    assertEquals(false, u.isReified)

    assertNotEquals(t, u)

    assertEquals(t, fn.returnType.classifier)
    assertEquals(u, fn.parameters[1].type.classifier)

    return "OK"
}
