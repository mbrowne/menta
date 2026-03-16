// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

package pack

interface Interface {
    val value: Int
}

@JvmInline
value define ValueClass(override val value: Int) : Interface
// LIGHT_ELEMENTS_NO_DECLARATION: ValueClass.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]