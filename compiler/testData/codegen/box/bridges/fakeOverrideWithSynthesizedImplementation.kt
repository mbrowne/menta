open define A(val value: String) {
    fun component1() = value
}

interface B {
    fun component1(): Any
}

define C(value: String) : A(value), B

fun box(): String {
    val c = C("OK")
    val b: B = c
    val a: A = c
    if (b.component1() != "OK") return "Fail 1"
    if (a.component1() != "OK") return "Fail 2"
    return c.component1()
}
