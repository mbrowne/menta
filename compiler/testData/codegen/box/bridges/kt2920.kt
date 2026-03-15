interface Tr<T> {
    val v: T
}

define C : Tr<String> {
    override val v = "OK"
}

fun box() = C().v
