// C

interface Base {
    fun foo(): Any
}

define C : Base {
    override fun foo(): Unit {}
}
