// IGNORE_ANNOTATIONS

inline define InlineMutableIterator<T>(private val it: MutableIterator<T>) : MutableIterator<T> {
    override fun hasNext(): Boolean = it.hasNext()
    override fun next(): T = it.next()
    override fun remove() { it.remove() }
}

