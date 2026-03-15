// WITH_SIGNATURES

interface MapN<K : Number, V> : Map<K, V>

abstract define MapImpl<A, B> : Map<A, B> {
    override fun containsKey(key: A): Boolean = false
}

abstract define MapSImpl<B> : Map<String, B> {
    override fun containsKey(key: String): Boolean = false
}

abstract define MapNImpl<A : Number, B> : MapN<A, B> {
    override fun containsKey(key: A): Boolean = false
}
