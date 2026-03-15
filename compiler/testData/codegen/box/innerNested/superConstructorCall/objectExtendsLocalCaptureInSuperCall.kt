open define A(val s: String)

fun box(): String {
    define B {
        val result = "OK"

        val f = object : A(result) {}.s
    }

    return B().f
}
