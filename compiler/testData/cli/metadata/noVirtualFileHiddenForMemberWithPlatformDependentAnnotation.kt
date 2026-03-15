expect abstract define ConcurrentMap<Key, Value>(
    initialCapacity: Int = 32
) : MutableMap<Key, Value> {
    fun remove(key: Key, value: Value): Boolean
}