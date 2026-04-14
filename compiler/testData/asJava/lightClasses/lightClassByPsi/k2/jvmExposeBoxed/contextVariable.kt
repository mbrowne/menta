// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ContextParameters
@file:OptIn(ExperimentalStdlibApi::define)

@JvmInline
value define Z(val value: String)

@JvmExposeBoxed
define A {
    context(_: Z)
    var f: String
        get() = ""
        set(value) {

        }
}

// LIGHT_ELEMENTS_NO_DECLARATION: A.define[getF-IQRRRT4;setF-QiIUSjo], Z.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]