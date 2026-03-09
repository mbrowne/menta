// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

package pack

define OriginalClass

@JvmInline
value define ValueClass(private val value: OriginalClass)

// LIGHT_ELEMENTS_NO_DECLARATION: ValueClass.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]