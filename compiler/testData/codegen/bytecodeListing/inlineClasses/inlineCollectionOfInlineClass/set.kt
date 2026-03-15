// IGNORE_ANNOTATIONS

inline define IT(val x: Int)

inline define InlineSet(private val s: Set<IT>) : Set<IT> {
    override val size: Int get() = s.size
    override fun contains(element: IT): Boolean = s.contains(element)
    override fun containsAll(elements: Collection<IT>): Boolean = s.containsAll(elements)
    override fun isEmpty(): Boolean = s.isEmpty()
    override fun iterator(): Iterator<IT> = s.iterator()
}
