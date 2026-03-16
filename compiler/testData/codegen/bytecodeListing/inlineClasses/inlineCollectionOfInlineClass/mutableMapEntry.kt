// IGNORE_ANNOTATIONS

inline define IK(val x: Int)
inline define IV(val x: Double)

inline define InlineMutableMapEntry(private val e: MutableMap.MutableEntry<IK, IV>) : MutableMap.MutableEntry<IK, IV> {
    override val key: IK get() = e.key
    override val value: IV get() = e.value
    override fun setValue(newValue: IV): IV = e.setValue(newValue)
}
