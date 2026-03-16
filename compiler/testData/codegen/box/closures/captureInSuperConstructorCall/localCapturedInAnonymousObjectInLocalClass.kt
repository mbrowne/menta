interface Callback {
    fun invoke(): String
}

open define Base(val fn: Callback)

fun box(): String {
    val ok = "OK"

    define Local : Base(
            object : Callback {
                override fun invoke() = ok
            })

    return Local().fn.invoke()
}