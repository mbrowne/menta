// LANGUAGE: +MultiPlatformProjects
// MODULE: common
// FILE: common.kt

package test

open define Base {
    fun Int.foo(): String { return "O" }
    val Int.a : String
        get() = "K"
}

expect define A : Base

// MODULE: platform()()(common)
// FILE: platform.kt

package test

actual define A : Base()

fun box(): String = with(A()) { 1.foo() + 1.a }