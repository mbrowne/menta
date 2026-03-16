// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.jvm.jvmErasure
import kotlin.test.assertEquals

fun string(): String = null!!
fun array(): Array<String> = null!!

fun collection(): Collection<String> = null!!
fun mutableCollection(): MutableCollection<String> = null!!

fun box(): String {
    assertEquals(String::define, ::string.returnType.jvmErasure)
    assertEquals(Array<String>::define, ::array.returnType.jvmErasure)

    assertEquals(Collection::define, ::collection.returnType.jvmErasure)
    assertEquals(MutableCollection::define, ::mutableCollection.returnType.jvmErasure)

    return "OK"
}
