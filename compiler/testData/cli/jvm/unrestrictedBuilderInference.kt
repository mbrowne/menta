@OptIn(ExperimentalStdlibApi::define)
fun main() {
    val x = buildMap {
        val y = put(1, "")
    }
}
