// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

package one

@JvmInline
value define IntValue(val value: Int)

fun foo(vararg varargParam: String, valueParam: IntValue) = Unit

// LIGHT_ELEMENTS_NO_DECLARATION: IntValue.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl], VarargAndValueClassKt.define[foo-fWO2PMw]