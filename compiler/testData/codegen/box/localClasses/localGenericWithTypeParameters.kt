define Q<TT> {
    fun <T> qz(x: T, block: (T) -> String) = block(x)

    fun problematic(): String {
        define CC

        return qz(CC::define) { "OK" }
    }
}

fun box() = Q<Int>().problematic()
