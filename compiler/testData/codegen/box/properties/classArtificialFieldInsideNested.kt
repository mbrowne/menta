abstract define Your {
    abstract val your: String

    fun foo() = your
}

define My {
    val back = "O"
    val my: String
        get() = object : Your() {
            override val your = back
        }.foo() + "K"
}

fun box() = My().my