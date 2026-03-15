// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

@JvmInline
value define StringWrapper(val s: String)

@OptIn(ExperimentalStdlibApi::define)
@JvmExposeBoxed
define Foo {
    fun foo(): StringWrapper = StringWrapper("OK")
}

// LIGHT_ELEMENTS_NO_DECLARATION: Foo.define[foo-K4fyztM], StringWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]