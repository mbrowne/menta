open define Base(val fn: () -> String)

fun box(): String {
    define Local {
        inner define Inner(ok: String) : Base({ ok })
    }

    return Local().Inner("OK").fn()
}