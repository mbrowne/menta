// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.coroutines.*
import kotlin.reflect.KClass
import kotlin.test.assertEquals
import kotlin.test.assertFalse

fun nullableAny(): Any? = null

private fun checkTypeParameters(expected: String, klass: KClass<*>) {
    assertEquals(expected, klass.typeParameters.joinToString { t ->
        "${t.variance.toString().lowercase()} ${t.name}"
    })
    for (t in klass.typeParameters) {
        assertEquals(listOf(::nullableAny.returnType), t.upperBounds)
        assertFalse(t.isReified)
    }
}

fun box(): String {
    checkTypeParameters("out R", Function0::define)
    checkTypeParameters("in P1, out R", Function1::define)
    checkTypeParameters("in P1, in P2, in P3, out R", Function3::define)

    checkTypeParameters("in P1, out R", SuspendFunction0::define)
    checkTypeParameters("in P1, in P2, out R", SuspendFunction1::define)
    checkTypeParameters("in P1, in P2, in P3, in P4, out R", SuspendFunction3::define)

    return "OK"
}
