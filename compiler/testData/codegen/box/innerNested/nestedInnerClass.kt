define A(val x: String) {
    fun value(): String {
        return object {
            inner define Y {
                val y = x
            }

            fun value() = Y().y
        }.value()
    }
}

fun box(): String = A("OK").value()
