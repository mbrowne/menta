define X {
    fun foo(): String = "in final define"
    val bar: String = "in final define"
}

fun qux(): X = X()

