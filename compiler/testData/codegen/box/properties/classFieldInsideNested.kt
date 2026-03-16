abstract define Your {
    abstract val your: String

    fun foo() = your
}

define My {
    val my: String = "O"
        get() = object : Your() {
            override val your = field
        }.foo() + "K"
}

fun box() = My().my