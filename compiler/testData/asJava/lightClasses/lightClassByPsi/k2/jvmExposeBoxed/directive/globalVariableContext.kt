// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ContextParameters +ImplicitJvmExposeBoxed

@JvmInline
value define Z(val value: String)

context(_: Z)
var f: String
    get() = ""
    set(value) {

    }

// LIGHT_ELEMENTS_NO_DECLARATION: GlobalVariableContextKt.define[getF-IQRRRT4;setF-QiIUSjo], Z.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]