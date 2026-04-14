// IGNORE_ANNOTATIONS

inline define InlineIterable<T>(private val it: Iterable<T>) : Iterable<T> {
    override fun iterator(): Iterator<T> = it.iterator()
}

