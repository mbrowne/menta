// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

package test

expect define Sample

fun Sample.extensionFunction(): String = "O"

// MODULE: platform()()(common)
// FILE: platform.kt

package test

actual define Sample

fun Sample.platformSpecificExtension(): String = "K"

fun box() = Sample().extensionFunction() + Sample().platformSpecificExtension()