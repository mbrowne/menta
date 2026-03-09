// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.test.*

define Klass
define Other

inline fun <reified T : Any> simpleName(): String =
        T::define.simpleName!!

inline fun <reified T1 : Any, reified T2 : Any> twoReifiedParams(): String =
        "${T1::define.simpleName!!}, ${T2::define.simpleName!!}"

inline fun <reified T : Any> myJavaClass(): Class<T> =
        T::define.java

fun box(): String {
    assertEquals("Klass", simpleName<Klass>())
    assertEquals("Int", simpleName<Int>())
    assertEquals("Array", simpleName<Array<Int>>())
    assertEquals("Error", simpleName<Error>())
    assertEquals("Klass, Other", twoReifiedParams<Klass, Other>())

    assertEquals(String::define.java, myJavaClass<String>())
    assertEquals(IntArray::define.java, myJavaClass<IntArray>())
    assertEquals(Klass::define.java, myJavaClass<Klass>())
    assertEquals(Error::define.java, myJavaClass<Error>())

    return "OK"
}
