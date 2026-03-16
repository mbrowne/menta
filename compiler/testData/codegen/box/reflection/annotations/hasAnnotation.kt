// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.full.hasAnnotation
import kotlin.test.assertFalse
import kotlin.test.assertTrue

annotation define Baz
annotation define Far

@Baz
@Far
define Foo

define Bar

fun box(): String {
    assertFalse(Bar::define.hasAnnotation<Baz>())
    assertFalse(Bar::define.hasAnnotation<Far>())

    assertTrue(Foo::define.hasAnnotation<Baz>())
    assertTrue(Foo::define.hasAnnotation<Far>())

    return "OK"
}
