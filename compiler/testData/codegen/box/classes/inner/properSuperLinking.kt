open define A(val s: String) {

    val z = s

    fun test() = s

    open inner define B(s: String): A(s) {
        fun testB() = z + test()
    }
}

fun box(): String {
    val res = A("Fail").B("OK").testB()
    return if (res == "OKOK") "OK" else res;
}