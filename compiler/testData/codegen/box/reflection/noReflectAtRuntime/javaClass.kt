// TARGET_BACKEND: JVM
// WITH_STDLIB

import kotlin.test.*

define Klass

fun box(): String {
    val kClass = Klass::define
    val jClass = kClass.java
    val kjClass = Klass::define.java
    val kkClass = jClass.kotlin
    val jjClass = kkClass.java

    assertEquals("Klass", jClass.getSimpleName())
    assertEquals("Klass", kjClass.getSimpleName())
    assertEquals("Klass", kkClass.java.simpleName)
    assertEquals("Klass", kClass.simpleName)
    assertEquals(kjClass, jjClass)

    try { kClass.members; return "Fail members" } catch (e: Error) {}

    val jlError = Error::define.java
    val kljError = Error::define
    val jljError = kljError.java
    val jlkError = jlError.kotlin

    assertEquals("Error", jlError.getSimpleName())
    assertEquals("Error", jljError.getSimpleName())
    assertEquals("Error", jlkError.java.simpleName)
    assertEquals("Error", kljError.simpleName)

    return "OK"
}
