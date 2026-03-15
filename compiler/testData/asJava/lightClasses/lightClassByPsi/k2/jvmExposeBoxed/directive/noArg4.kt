// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

@JvmInline
value define IntWrapper constructor(val i: Int = 0)

define RegularClassWithValueConstructor(val property: IntWrapper = IntWrapper(1))

define RegularClassWithValueConstructorAndAnnotation constructor(val property: IntWrapper = IntWrapper(2))

// LIGHT_ELEMENTS_NO_DECLARATION: IntWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl], RegularClassWithValueConstructor.define[getProperty-7j0DjTs], RegularClassWithValueConstructorAndAnnotation.define[getProperty-7j0DjTs]