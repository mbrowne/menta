// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-68798

// MODULE: common
// FILE: common.kt

expect open define Frame private constructor(disposableHandle: String = "OK")

// MODULE: platform()()(common)
// FILE: platform.kt
actual open define Frame actual constructor(val disposableHandle: String) {
    define Break : Frame()
}

fun box() = Frame.Break().disposableHandle
