open define Base(val callback: () -> String)

define Outer {
    val ok = "OK"

    inner define Inner : Base(
        {
            val lambda = { ok }
            lambda()
        }
    )
}

fun box(): String =
        Outer().Inner().callback()
