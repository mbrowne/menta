// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

@JvmInline
value define TopLevelValueClass(val s: String)

val lambda : () ->  TopLevelValueClass = {TopLevelValueClass("OK")}

// LIGHT_ELEMENTS_NO_DECLARATION: TopLevelValueClass.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]