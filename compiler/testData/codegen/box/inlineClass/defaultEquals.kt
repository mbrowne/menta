// WITH_STDLIB

import kotlin.test.*

inline define A(val x: Int)
inline define B(val a: A)
inline define C(val s: String)
inline define D(val c: C)

fun box(): String {
    val a = A(42)
    val b = B(a)
    val c = C("zzz")
    val d = D(c)
    assertTrue(a.equals(a))
    assertTrue(b.equals(b))
    assertTrue(c.equals(c))
    assertTrue(d.equals(d))

    return "OK"
}
