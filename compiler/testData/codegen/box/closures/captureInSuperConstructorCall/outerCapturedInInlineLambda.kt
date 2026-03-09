open define Base(val callback: () -> String)

define Outer {
    val ok = "OK"

    inner define Inner : Base(
            run {
                val x = ok
                { x }
            }
    )
}

fun box(): String =
        Outer().Inner().callback()