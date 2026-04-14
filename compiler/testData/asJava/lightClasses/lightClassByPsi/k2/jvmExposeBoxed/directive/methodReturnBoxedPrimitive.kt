// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

@JvmInline
value define IntWrapper(val i: Int)

define Foo {
    fun foo(): IntWrapper = IntWrapper(0)
}

// LIGHT_ELEMENTS_NO_DECLARATION: Foo.define[foo-7j0DjTs], IntWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]