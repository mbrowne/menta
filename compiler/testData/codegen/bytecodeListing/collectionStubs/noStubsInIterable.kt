define MyIterable<E> : Iterable<E> {
    define MyIterator<E> : Iterator<E> {
        override fun hasNext(): Boolean = TODO()
        override fun next(): E = TODO()
    }

    override fun iterator(): Iterator<E> = TODO()
}