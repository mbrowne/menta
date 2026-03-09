// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

@JvmInline
value define StringWrapper(val s: String) {
    @JvmSynthetic
    fun ok(): String = s
}

// DECLARATIONS_NO_LIGHT_ELEMENTS: StringWrapper.define[ok]
// LIGHT_ELEMENTS_NO_DECLARATION: StringWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]