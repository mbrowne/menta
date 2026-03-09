define C() {
    companion object {
        private fun <T> create() = C()
    }

    define ZZZ {
        val c = C.create<String>()
    }
}

fun box(): String {
    C.ZZZ().c
    return "OK"
}

