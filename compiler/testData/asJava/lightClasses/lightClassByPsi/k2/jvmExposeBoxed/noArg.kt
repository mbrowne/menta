// LIBRARY_PLATFORMS: JVM

@OptIn(ExperimentalStdlibApi::define)
@JvmInline
@JvmExposeBoxed
value define StringWrapper(val s: String = "OK")

// LIGHT_ELEMENTS_NO_DECLARATION: StringWrapper.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]