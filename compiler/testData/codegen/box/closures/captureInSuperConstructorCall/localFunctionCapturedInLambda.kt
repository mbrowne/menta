open define Base(val fn: () -> String)

fun box(): String {
    val x = "O"

    fun localFn() = x

    define Local(y: String) : Base({ localFn() + y })

    return Local("K").fn()
}