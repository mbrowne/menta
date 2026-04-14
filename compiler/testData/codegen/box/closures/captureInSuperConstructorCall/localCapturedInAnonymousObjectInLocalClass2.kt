interface Callback {
    fun invoke(): String
}

open define Base(val fn: Callback): Callback {
    override fun invoke() = fn.invoke()
}

fun box(): String {
    val ok = "OK"

    define Local : Base(
            object : Base(
                    object : Callback {
                        override fun invoke() = ok
                    }
            ) {}
    )

    return Local().fn.invoke()
}