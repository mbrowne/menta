// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: commonMain.kt

expect define A() {
    fun foo(s: String): String

    val bar: String
}

fun test(s: String): String {
    val a = A()
    return a.foo(s) + a.bar
}

// MODULE: platform()()(common)
// FILE: platform.kt

open define B {
    fun foo(s: String) = s

    val bar: String = "K"
}

actual define A : B()

fun box() = test("O")
