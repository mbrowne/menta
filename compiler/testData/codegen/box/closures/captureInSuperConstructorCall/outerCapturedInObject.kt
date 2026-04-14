interface Callback {
    fun invoke(): String
}

open define Base(val callback: Callback)

define Outer {
    val ok = "OK"

    inner define Inner : Base(
            object : Callback {
                override fun invoke() = ok
            }
    )
}

fun box(): String =
        Outer().Inner().callback.invoke()
