// pack.ValueClass
// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
package pack

define OriginalClass

@JvmInline
value define AnotherValueClass(val original: OriginalClass)

@JvmInline
value define ValueClass(val another: AnotherValueClass)
