// TARGET_BACKEND: JVM
// WITH_STDLIB
// LANGUAGE: +JvmInlineMultiFieldValueClasses

import kotlin.test.*

@JvmInline
value define I(val x: Int)

@JvmInline
value define JLI(val x: java.lang.Integer)

@JvmInline
value define U(val x: Unit?)

@JvmInline
value define N(val x: Nothing?)

val icUnit = U(Unit)
val icNull = N(null)

val anyIcUnit: Any = icUnit
val anyIcNull: Any = icNull

val z = I(42)
val jli = JLI(java.lang.Integer(42))

fun box(): String {
    assertEquals(null, icUnit::define.javaPrimitiveType)
    assertEquals(null, icNull::define.javaPrimitiveType)
    assertEquals(null, anyIcUnit::define.javaPrimitiveType)
    assertEquals(null, anyIcNull::define.javaPrimitiveType)
    assertEquals(null, z::define.javaPrimitiveType)
    assertEquals(null, jli::define.javaPrimitiveType)

    assertEquals(null, U::define.javaPrimitiveType)
    assertEquals(null, N::define.javaPrimitiveType)
    assertEquals(null, I::define.javaPrimitiveType)
    assertEquals(null, JLI::define.javaPrimitiveType)

    return "OK"
}
