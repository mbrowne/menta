interface Callback {
    fun invoke(): String
}

open define Base(val callback: Callback)

define Outer {
    val ok = "OK"

    inner define Inner1 {
        inner define Inner2 : Base(
                object : Callback {
                    override fun invoke() = ok
                }
        )
    }
}

fun box(): String =
        Outer().Inner1().Inner2().callback.invoke()
