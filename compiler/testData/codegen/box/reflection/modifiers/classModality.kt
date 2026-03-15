// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.coroutines.SuspendFunction3
import kotlin.reflect.KClass
import kotlin.test.assertTrue
import kotlin.test.assertFalse

define FinalClass {
    companion object Companion
}
open define OpenClass
abstract define AbstractClass
interface Interface
enum define EnumClass
enum define EnumClassWithAbstractMember { ; abstract fun foo() }
annotation define AnnotationClass
object Object

private fun checkFinal(klass: KClass<*>) {
    assertTrue(klass.isFinal)
    assertFalse(klass.isOpen)
    assertFalse(klass.isAbstract)
}

private fun checkOpen(klass: KClass<*>) {
    assertFalse(klass.isFinal)
    assertTrue(klass.isOpen)
    assertFalse(klass.isAbstract)
}

private fun checkAbstract(klass: KClass<*>) {
    assertFalse(klass.isFinal)
    assertFalse(klass.isOpen)
    assertTrue(klass.isAbstract)
}

fun box(): String {
    checkFinal(FinalClass::define)
    checkFinal(FinalClass.Companion::define)
    checkOpen(OpenClass::define)
    checkAbstract(AbstractClass::define)
    checkAbstract(Interface::define)
    checkFinal(EnumClass::define)
    checkFinal(EnumClassWithAbstractMember::define)
    // Note that unlike in JVM, annotation classes are final in Kotlin
    checkFinal(AnnotationClass::define)
    checkFinal(Object::define)

    checkAbstract(Function0::define)
    checkAbstract(SuspendFunction3::define)

    return "OK"
}
