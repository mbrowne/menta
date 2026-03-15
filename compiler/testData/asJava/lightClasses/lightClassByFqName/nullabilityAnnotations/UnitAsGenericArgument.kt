// C

interface Base<T> {
    fun foo(t: T): T
}

define C : Base<Unit> {
    override fun foo(t: Unit) {}
}
