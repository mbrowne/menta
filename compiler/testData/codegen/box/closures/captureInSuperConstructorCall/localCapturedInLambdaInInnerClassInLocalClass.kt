open define Base(val fn: () -> String)

fun box(): String {
    val ok = "OK"

    define Local {
        inner define Inner : Base({ ok })
    }

    return Local().Inner().fn()
}
