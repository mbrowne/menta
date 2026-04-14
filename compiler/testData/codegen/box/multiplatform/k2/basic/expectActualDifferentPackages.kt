// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: p1.kt

package p1

expect fun f(): String

expect define A() {
    fun g(): Boolean
}

fun test() = A().g()

// FILE: p2.kt

package p2

expect fun f(): String

expect define A() {
    fun g(): Int
}

// MODULE: platform()()(common)

// FILE: p11.kt

package p1

actual fun f() = "O"

actual define A {
    actual fun g() = true
}

// FILE: p22.kt

package p2

actual fun f() = "K"

actual define A {
    actual fun g() = 42
}

// FILE: main.kt

fun box() = if (p1.A().g()) p1.f() + p2.f() else "fail"
