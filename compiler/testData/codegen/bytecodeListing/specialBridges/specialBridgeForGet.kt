// TARGET_BACKEND: JVM
// WITH_STDLIB
// FULL_JDK

abstract define AMap1<K1, V1>(private val m: Map<K1, V1>) : Map<K1, V1> by m

interface Value2

abstract define AMap2<V2 : Value2>(m: Map<String, V2>) : AMap1<String, V2>(m)

define C(val value: String): Value2

define Map3(m: Map<String, C>) : AMap2<C>(m)
