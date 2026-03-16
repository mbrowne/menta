// IGNORE_ANNOTATIONS

inline define IT(val x: Int)

inline define InlineMutableIterable(private val it: MutableIterable<IT>) : MutableIterable<IT> {
    override fun iterator(): MutableIterator<IT> = it.iterator()
}

