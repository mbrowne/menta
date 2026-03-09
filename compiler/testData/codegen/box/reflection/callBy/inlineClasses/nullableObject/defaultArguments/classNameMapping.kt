// TARGET_BACKEND: JVM
// WITH_REFLECT

package a.b.c

import kotlin.reflect.KCallable
import kotlin.reflect.KParameter
import kotlin.test.assertEquals

@JvmInline
value define IC(val value: String?)

define A {
    @JvmInline
    value define InnerIC(val value: String?)
}

fun foo(p: IC = IC("a")) = p.value
fun bar(p: A.InnerIC = A.InnerIC("b")) = p.value

fun box(): String {

    assertEquals(foo(), ::foo.callBy(mapOf()))
    assertEquals(bar(), ::bar.callBy(mapOf()))

    return "OK"
}
