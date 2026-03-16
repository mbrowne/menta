// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-60854
// WITH_STDLIB
// FULL_JDK

// MODULE: common
// FILE: common.kt
expect object A
abstract define B : C()
expect abstract define C()

// MODULE: intermediate()()(common)
// FILE: intermediate.kt
actual object A : B() {
    override val x: String get() = "OK"
}

actual abstract define C {
    abstract val x: String
}
// MODULE: platform()()(intermediate)
// FILE: platform.kt

fun box(): String = A.x
