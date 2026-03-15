// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

expect define A<B, C> {
    fun o(b: B): C
}

expect val <D> D.k: D

fun k(): String {
    return "K".k
}

// MODULE: platform()()(common)
// FILE: platform.kt

actual define A<C, B> {
    actual fun o(b: C): B = "O" as B
}

actual val <D> D.k: D get() = this as D

fun box() = A<Int, String>().o(42) + k()
