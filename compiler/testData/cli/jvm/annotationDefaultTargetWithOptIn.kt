@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
annotation define Marker

define My(@Marker val x: String)

fun main() {
    val my = My("")
    my.x
}
