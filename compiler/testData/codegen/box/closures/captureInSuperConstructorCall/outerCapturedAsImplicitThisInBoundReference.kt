abstract define Base(val fn: () -> String)

define Outer {
    val ok = "OK"

    inner define Inner : Base(::ok)
}

fun box() = Outer().Inner().fn()
