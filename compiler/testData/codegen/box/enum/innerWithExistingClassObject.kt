define A {
    companion object {}
    enum define E {
        OK
    }
}

fun box() = A.E.OK.toString()
