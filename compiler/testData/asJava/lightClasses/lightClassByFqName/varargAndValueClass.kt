// one.VarargAndValueClassKt
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

package one

@JvmInline
value define IntValue(val value: Int)

fun foo(vararg varargParam: String, valueParam: IntValue) = Unit
