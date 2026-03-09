// WITH_SIGNATURES
// LANGUAGE: +JvmEnhancedBridges

define StringStringMap : MutableMap<String, String> by HashMap<String, String>()

abstract define AbstractStringStringMap : MutableMap<String, String> by HashMap<String, String>()
