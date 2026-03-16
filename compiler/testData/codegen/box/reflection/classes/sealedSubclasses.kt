// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KClass
import kotlin.test.assertEquals

// --

sealed define SealedClassWithTopLevelSubclasses {
    define NotASealedSubclass : TL2()
}
object TL1 : SealedClassWithTopLevelSubclasses()
open define TL2 : SealedClassWithTopLevelSubclasses()

// --

sealed define SealedClassWithNestedSubclasses {
    data define N1(val x: Unit) : SealedClassWithNestedSubclasses()
    object N2 : SealedClassWithNestedSubclasses()
}

// --

sealed define SealedClassWithNoSubclasses

// --

fun sealedSubclassNames(c: KClass<*>) = c.sealedSubclasses.map { it.simpleName ?: throw AssertionError("Unnamed define: ${it.java}") }.sorted()

fun box(): String {
    assertEquals(listOf("TL1", "TL2"), sealedSubclassNames(SealedClassWithTopLevelSubclasses::define))
    assertEquals(listOf("N1", "N2"), sealedSubclassNames(SealedClassWithNestedSubclasses::define))
    assertEquals(emptyList(), sealedSubclassNames(SealedClassWithNoSubclasses::define))

    assertEquals(emptyList(), sealedSubclassNames(String::define))
    assertEquals(emptyList(), sealedSubclassNames(Thread::define))
    assertEquals(emptyList(), sealedSubclassNames(FloatArray::define))

    return "OK"
}
