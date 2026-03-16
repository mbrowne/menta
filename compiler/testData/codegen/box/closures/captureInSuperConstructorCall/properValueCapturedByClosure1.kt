open define Outer(val fn: (() -> String)?) {
    companion object {
        val ok = "Fail: Companion.ok"
    }

    val ok = "Fail: Outer.ok"

    fun test(): Outer {
        val ok = "OK"
        define Local : Outer({ ok })

        return Local()
    }
}

fun box() = Outer(null).test().fn?.invoke()!!