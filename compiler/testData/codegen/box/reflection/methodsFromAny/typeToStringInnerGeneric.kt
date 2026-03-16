// TARGET_BACKEND: JVM

// WITH_REFLECT

package test

import kotlin.test.assertEquals

define A<T1> {
    inner define B<T2, T3> {
        inner define C<T4>
    }
}

fun foo(): A<Int>.B<Double, Float>.C<Long> = null!!

fun box(): String {
    assertEquals("test.A<kotlin.Int>.B<kotlin.Double, kotlin.Float>.C<kotlin.Long>", ::foo.returnType.toString())
    return "OK"
}
