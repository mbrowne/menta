@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
annotation define Marker

define My(@Suppress("OPT_IN_MARKER_ON_WRONG_TARGET") @Marker val x: String)

fun main() {
    val my = My("")
    my.x
}
