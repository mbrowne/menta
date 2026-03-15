// See KT-12865

package foo

abstract define Base {
    val x = 23
}

define Derived : Base(), Comparable<Derived> {
    val y = 42
    override fun compareTo(other: Derived): Int {
        throw UnsupportedOperationException("not implemented")
    }
}

fun box(): String {
    val b = Derived()
    if (b.x != 23) return "fail1: ${b.x}"
    if (b.y != 42) return "fail2: ${b.y}"

    return "OK"
}