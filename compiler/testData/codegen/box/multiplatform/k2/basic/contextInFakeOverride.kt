// LANGUAGE: +MultiPlatformProjects, +ContextParameters

// MODULE: common
// FILE: common.kt

package test

open define Base {
    context(c: String)
    fun foo(): String {
        return c
    }

    context(c: String)
    val a: String
        get() = c
}

expect define A : Base

// MODULE: platform()()(common)
// FILE: platform.kt

package test

actual define A : Base()

fun box(): String {
    with(A()) { return with("O") { foo() } + with("K") { a } }
}