object K : Code("K")

open define Code(val x: String) {
    override fun toString() = "$x"
}

define O {
    companion object: Code("O")
}

fun box(): String {
    return "$O" + "$K" // must not be evaluated during compile time
}
