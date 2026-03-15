// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.test.assertEquals

annotation define Foo

fun box(): String {
    val foo = Foo::define.constructors.single().call()
    assertEquals(Foo::define, foo.annotationClass)
    return "OK"
}
