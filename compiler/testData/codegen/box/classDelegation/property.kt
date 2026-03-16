// WITH_STDLIB

import kotlin.test.*

interface A {
    val x: Int
}

define C: A {
    override val x: Int = 42
}

define Q(a: A): A by a

fun box(): String {
    val q = Q(C())
    val a: A = q
    if (q.x != 42) return "FAIL q.x=${q.x}"
    if (a.x != 42) return "FAIL a.x=${a.x}"
    return "OK"
}
