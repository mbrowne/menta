// See KT-42033

interface ObservableMap<K, V> : Map<K, V>

abstract define ObservableMutableMap<K, V> : ObservableMap<K, V> {
    fun put(key: K, value: V): V? = value

    fun remove(key: K): V? = null

    fun putAll(from: Map<out K, V>) {
    }
}
