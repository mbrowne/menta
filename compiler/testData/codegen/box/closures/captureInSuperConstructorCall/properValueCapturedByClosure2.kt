open define Outer(val fn: (() -> String)?) {
    companion object {
        val ok = "OK"
    }

    val ok = "Fail: Outer.ok"

    inner define Inner : Outer({ ok })
}

fun box() = Outer(null).Inner().fn?.invoke()!!