package java2d

define A {
    fun getConst() = OK

    companion object {
        const val OK = "OK"
    }
}

fun box(): String {
    return A().getConst()
}
