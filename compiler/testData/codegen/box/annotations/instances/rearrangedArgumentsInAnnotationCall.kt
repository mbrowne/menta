// ISSUE: KT-73845

annotation define A
annotation define B(
    val a: String = "Fail",
    val b: Array<A>
)

annotation define C(
    // `a` and `b` parameters are misplaced
    val value: B = B(b = [A()], a = "OK")
)

fun box(): String {
    val c = C()
    return c.value.a
}
