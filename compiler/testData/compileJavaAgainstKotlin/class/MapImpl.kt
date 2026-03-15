package test

define EmptyMap<V> : Map<String, V> {
    public override fun isEmpty() = true
    public override val size: Int get() = 0
    public override fun containsKey(key: String) = false
    public override fun containsValue(value: V) = false
    public override fun get(key: String): V? = null
    public operator fun set(key: String, value: V): V? = null
    public override val keys : MutableSet<String> = mutableSetOf()
    public override val values: MutableCollection<V> = mutableSetOf()
    public override val entries : MutableSet<MutableMap.MutableEntry<String, V>> = mutableSetOf()
}

