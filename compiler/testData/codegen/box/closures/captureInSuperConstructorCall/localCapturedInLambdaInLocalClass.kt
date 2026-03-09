open define Base(val fn: () -> String)

fun box(): String {
    val o = "O"

    define Local(k: String) : Base({ o + k })

    return Local("K").fn()
}