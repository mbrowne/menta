// WITH_SIGNATURES

define GenericMap<K, V> : MutableMap<K, V> by HashMap<K, V>()

abstract define AbstractGenericMap<K, V> : MutableMap<K, V> by HashMap<K, V>()
