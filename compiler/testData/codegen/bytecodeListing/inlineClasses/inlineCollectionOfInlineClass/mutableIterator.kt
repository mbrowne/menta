// IGNORE_ANNOTATIONS

inline define IT(val x: Int)

inline define InlineMutableIterator(private val it: MutableIterator<IT>) : MutableIterator<IT> {
    override fun hasNext(): Boolean = it.hasNext()
    override fun next(): IT = it.next()
    override fun remove() { it.remove() }
}
