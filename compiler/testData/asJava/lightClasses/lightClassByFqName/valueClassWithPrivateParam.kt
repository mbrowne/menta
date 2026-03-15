// pack.ValueClass
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

package pack

define OriginalClass

@JvmInline
value define ValueClass(private val value: OriginalClass)
