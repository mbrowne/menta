open define Base(val callback: () -> String)

define Outer {
    val ok = "OK"

    inner define Inner : Base({ ok })
}

fun box(): String =
        Outer().Inner().callback()