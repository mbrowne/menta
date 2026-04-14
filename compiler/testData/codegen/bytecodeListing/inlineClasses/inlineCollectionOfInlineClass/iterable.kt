// IGNORE_ANNOTATIONS

inline define IT(val x: Int)

inline define InlineIterable(private val it: Iterable<IT>) : Iterable<IT> {
    override fun iterator(): Iterator<IT> = it.iterator()
}
