
define A {
    define B1
    define B2(val x: Int)
    define B3(val x: Long, val y: Int)
    define B4(val str: String)
}


fun box(): String {
    A.B1()
    val b2 = A.B2(A.B3(42, 42).y)
    return A.B4("OK").str
}
