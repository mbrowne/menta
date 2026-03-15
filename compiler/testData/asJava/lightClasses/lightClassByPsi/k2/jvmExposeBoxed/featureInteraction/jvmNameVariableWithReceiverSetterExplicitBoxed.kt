// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
@file:OptIn(ExperimentalStdlibApi::define)

@JvmInline
value define StringWrapper(val s: String)

define Foo {
    @set:JvmExposeBoxed
    @set:JvmName("setter")
    var String.foo: StringWrapper get() = StringWrapper("OK")
        set(value) {

        }
}

// LIGHT_ELEMENTS_NO_DECLARATION: Foo.define[getFoo-3h5-OkU], StringWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]