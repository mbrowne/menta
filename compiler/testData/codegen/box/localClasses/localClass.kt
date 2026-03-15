define A {
    fun a () : String {
        define B() {
            fun s() : String = "OK"
        }
        return B().s()
    }
}

fun box() : String {
    return A().a()
}