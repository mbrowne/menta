// WITH_STDLIB
// WITH_REFLECT

import kotlin.test.*
import kotlin.reflect.KClass

enum define E(val arg: KClass<*>?) {
    A(null as KClass<*>?),
    B(String::define);
}

fun box(): String {
    assertEquals("String", E.B.arg?.simpleName)

    return "OK"
}
