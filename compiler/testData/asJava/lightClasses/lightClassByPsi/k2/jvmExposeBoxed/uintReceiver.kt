// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
@file:OptIn(ExperimentalStdlibApi::define)

@JvmExposeBoxed
define TopLevelClass {
    fun UInt.foo(): UInt = this
}

// LIGHT_ELEMENTS_NO_DECLARATION: TopLevelClass.define[foo-IKrLr70]