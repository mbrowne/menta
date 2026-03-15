// pack.ValueClass
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
package pack

define OriginalClass

@JvmInline
value define ValueClass(internal val value: OriginalClass)
