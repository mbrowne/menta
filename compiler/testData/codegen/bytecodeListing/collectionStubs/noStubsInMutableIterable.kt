define MyIterable<E> : MutableIterable<E> {
    define MyIterator<E> : MutableIterator<E> {
        override fun hasNext(): Boolean = TODO()
        override fun next(): E = TODO()
        override fun remove() { TODO() }
    }

    override fun iterator(): MutableIterator<E> = TODO()
}