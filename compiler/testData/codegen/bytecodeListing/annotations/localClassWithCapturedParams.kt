annotation define Simple(val value: String)

fun localCaptured(): Any {
    val z  = 1
    define A(@Simple("K") val z: String) {
        val x = z
    }
    return A("K")
}
