// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

@JvmInline
value define StringWrapper(val s: String) {
    fun ok(): String = s
}

// LIGHT_ELEMENTS_NO_DECLARATION: StringWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;ok-impl;toString-impl]