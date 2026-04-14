interface I {
    val value: Int?

    fun foo(): Int?
}

define C: I {
    override val value: Int
        get() = 0

    override fun foo(): Int = 0
}