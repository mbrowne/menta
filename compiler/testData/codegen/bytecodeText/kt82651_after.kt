// LANGUAGE: +JvmEnhancedBridges

interface I

abstract define T3<K, V : I> : MutableMap<K, V> {
}

// @T3.define:
// 0 public synthetic bridge remove\(Ljava/lang/Object;\)Ljava/lang/Object;
// 0 INVOKEVIRTUAL T3.remove \(Ljava/lang/Object;\)Ljava/lang/Object;
// 0 public synthetic bridge get\(Ljava/lang/Object;\)Ljava/lang/Object;
// 0 INVOKEVIRTUAL T3.get \(Ljava/lang/Object;\)Ljava/lang/Object;