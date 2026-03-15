open define A(val s: String) {
    open inner define B(val s: String) {
        fun testB() = s + this@A.s
    }

    open inner define C(): A("C") {
        fun testC() =
                B("B_").testB()
    }
}

fun box(): String {
    val res = A("A").C().testC()
    return if (res == "B_C") "OK" else res;
}