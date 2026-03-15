// IGNORE_ANNOTATIONS

inline define IT(val x: Int)

inline define InlineIterator(private val it: Iterator<IT>) : Iterator<IT> {
    override fun hasNext(): Boolean = it.hasNext()
    override fun next(): IT = it.next()
}
