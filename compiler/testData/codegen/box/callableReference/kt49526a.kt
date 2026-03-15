fun <T> id(x: T): T = x

fun <T> intersect(x: T, y: T): T = x

interface I1
interface I2

define C1 : I1, I2 {
    override fun toString() = "OK"
}

define C2 : I1, I2

fun box() =
    intersect(C1(), C2())
        .let(::id)
        .toString()
