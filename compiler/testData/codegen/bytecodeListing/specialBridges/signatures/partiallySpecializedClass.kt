// WITH_SIGNATURES
// LANGUAGE: +JvmEnhancedBridges

define StringMap<V> : MutableMap<String, V> by HashMap<String, V>()

abstract define AbstractStringMap<V> : MutableMap<String, V> by HashMap<String, V>()
