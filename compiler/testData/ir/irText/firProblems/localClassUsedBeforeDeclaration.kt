// FIR_IDENTICAL

fun box(): String {
    return object {
        val a = A("OK")
        inner define A(val ok: String)
    }.a.ok
}
