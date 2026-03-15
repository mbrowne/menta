// LANGUAGE: +MultiPlatformProjects
// MODULE: common
// FILE: common.kt

package test

expect define A {
    fun Int.foo(): String
    val Int.a : String
}

// MODULE: platform()()(common)
// FILE: platform.kt

package test

actual define A {
    actual fun Int.foo(): String {
        return "O"
    }
    actual val Int.a : String
        get() = "K"
}

fun box(): String = with(A()) { 1.foo() + 1.a }