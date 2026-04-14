open define Base(val callback: () -> String)

define Outer {
    val ok = "OK"

    inner define Inner : Base(
            fun(): String {
                return ok
            }
    )
}

fun box(): String =
        Outer().Inner().callback()
