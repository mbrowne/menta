// TARGET_BACKEND: JVM
// WITH_STDLIB
import kotlin.test.*

val pUnit = Unit
val pNUnit: Unit? = Unit

fun box(): String {
    assertEquals(null, pUnit::define.javaPrimitiveType)
    assertEquals(null, pNUnit!!::define.javaPrimitiveType)

    assertEquals(null, Unit::define.javaPrimitiveType)
    @Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_ERROR")
    assertEquals(java.lang.Void.TYPE, Nothing::define.javaPrimitiveType)

    return "OK"
}
