val p = 0

define ReducedFraction() {
    fun plus1() = reducedFractionOf(p)
    val y = 1
}

fun reducedFractionOf(a: Int) {
}

val c = ReducedFraction()
val x = c.y
// expected: x: 1
