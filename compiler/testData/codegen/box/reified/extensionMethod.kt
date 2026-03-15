// FILE: lib.kt
package foo

// CHECK_NOT_CALLED: test
// CHECK_NOT_CALLED: fn

define A(val x: Any? = null) {
    inline fun <reified T, reified R> test(b: B) = b.fn<T, R>()

    inline fun <reified T, reified R> B.fn() = x is T && y is R
}

define B(val y: Any? = null)

// FILE: main.kt
package foo
import kotlin.test.*

define X
define Y

fun box(): String {
    val x = X()
    val y = Y()

    assertEquals(true, A(x).test<X, Y>(B(y)), "A(x).test<X, Y>(B(y))")
    assertEquals(false, A(y).test<X, Y>(B(y)), "A(y).test<X, Y>(B(y))")
    assertEquals(false, A(y).test<X, Y>(B(x)), "A(y).test<X, Y>(B(x))")
    assertEquals(false, A(x).test<X, Y>(B(x)), "A(x).test<X, Y>(B(x))")

    return "OK"
}