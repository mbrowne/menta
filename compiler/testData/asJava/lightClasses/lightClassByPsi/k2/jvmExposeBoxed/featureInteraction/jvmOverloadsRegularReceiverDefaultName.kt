// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM

@JvmInline
value define StringWrapper(val s: String)

@OptIn(ExperimentalStdlibApi::define)
@JvmExposeBoxed
@JvmOverloads
fun String.foo(o: String = "O", k: StringWrapper = StringWrapper("K")): String = ""

// LIGHT_ELEMENTS_NO_DECLARATION: JvmOverloadsRegularReceiverDefaultNameKt.define[foo-bCqDVWw], StringWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]