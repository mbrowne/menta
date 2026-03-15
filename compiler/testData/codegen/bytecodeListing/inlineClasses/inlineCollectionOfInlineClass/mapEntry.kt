// IGNORE_ANNOTATIONS

inline define IK(val x: Int)
inline define IV(val x: Double)

inline define InlineMapEntry(private val e: Map.Entry<IK, IV>) : Map.Entry<IK, IV> {
    override val key: IK get() = e.key
    override val value: IV get() = e.value
}
