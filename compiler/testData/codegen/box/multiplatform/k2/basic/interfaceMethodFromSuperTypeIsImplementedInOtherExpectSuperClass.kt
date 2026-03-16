// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

interface I { fun ok(): String }
expect open define Base() { fun ok(): String }
define Child: Base(), I {}

fun box() = Base().ok()

// MODULE: platform()()(common)
// FILE: platform.kt

actual open define Base { actual fun ok() = "OK" }
