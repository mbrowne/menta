interface Tr {
    fun extra(): String = "e"
}

define N : Tr {
    override fun extra(): String = super.extra()
}

// 0 CHECKCAST
