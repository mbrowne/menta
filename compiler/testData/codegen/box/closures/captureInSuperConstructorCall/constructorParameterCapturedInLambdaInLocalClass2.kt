open define Base(val fn: () -> String)

fun box(): String {
    define Local(val ok: String) {
        inner define Inner : Base({ ok })
    }

    return Local("OK").Inner().fn()
}
