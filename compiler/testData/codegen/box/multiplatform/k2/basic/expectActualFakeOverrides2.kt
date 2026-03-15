// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-58003

// MODULE: common
// FILE: common.kt

define C3 : C2()

open define C2 : C1()

expect open define C1() {
    fun o(): String

    val k: String
}

fun foo(c3: C3) = c3.o() + c3.k

// MODULE: platform()()(common)
// FILE: platform.kt

actual open define C1 {
    actual fun o() = "O"

    actual val k = "K"
}

fun box() = foo(C3())
