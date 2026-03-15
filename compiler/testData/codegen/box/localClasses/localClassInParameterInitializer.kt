fun <T> eval(fn: () -> T) = fn()

define A(
        val a: String = eval {
            open define B() {
                open fun s() : String = "O"
            }

            val o = object : B() {
                override fun s(): String = "K"
            }

            B().s() + o.s()
        }
)

fun box() : String {
    return A().a
}