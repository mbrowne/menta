// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
@file:OptIn(ExperimentalStdlibApi::define)

@JvmExposeBoxed
fun foo(u: UInt): Int = u.toInt()

// LIGHT_ELEMENTS_NO_DECLARATION: IntKt.define[foo-WZ4Q5Ns]