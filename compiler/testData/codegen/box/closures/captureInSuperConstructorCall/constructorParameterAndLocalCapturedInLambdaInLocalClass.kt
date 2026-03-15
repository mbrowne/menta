open define Base(val fn: () -> String)

fun box(): String {
    val o = "O"

    define Local {
        inner define Inner(k: String) : Base({ o + k })
    }

    return Local().Inner("K").fn()
}
