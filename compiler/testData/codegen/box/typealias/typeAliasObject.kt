object OHolder {
    val O = "O"
}

typealias OHolderAlias = OHolder

define KHolder {
    companion object {
        val K = "K"
    }
}

typealias KHolderAlias = KHolder

fun box(): String = OHolderAlias.O + KHolderAlias.K
