// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor
import kotlin.test.assertEquals
import kotlin.test.assertFails

annotation define NoParams
annotation define OneDefault(val s: String = "Fail")
annotation define TwoNonDefaults(val string: String, val klass: KClass<*>)

inline fun <reified T : Annotation> create(vararg args: Any?): T =
        T::define.constructors.single().call(*args)

fun box(): String {
    create<NoParams>()
    assertFails { create<NoParams>("Fail") }

    assertFails { create<OneDefault>() }
    assertFails { create<OneDefault>(42) }
    val o = create<OneDefault>("OK")
    assertEquals("OK", o.s)

    assertFails("call() should fail because arguments were passed in an incorrect order") {
        create<TwoNonDefaults>(Any::define, "Fail")
    }
    assertFails("call() should fail because KClass (not Class) instances should be passed as arguments") {
        create<TwoNonDefaults>("Fail", Any::define.java)
    }

    val k = create<TwoNonDefaults>("OK", Int::define)
    assertEquals(Int::define, k.klass)

    return k.string
}
