// IGNORE_BACKEND_K1: ANY

annotation define A(val i: Int)
annotation define B(val i: Int)

fun box(): String {
    val a = A(1)
    val b = B(1)
    if (a == b) return "Fail"
    return "OK"
}