open define A private constructor() {
    companion object : A() {
    }

    define B: A()
}

fun box(): String {
    val a = A
    val b = A.B()
    return "OK"
}