// C

interface Tr {
    fun foo(): Any
    val v: Any
}

define C: Tr {
    override fun foo() = 1
    override val v = { 1 }()
}