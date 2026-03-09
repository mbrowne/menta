// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-68801

// MODULE: common
// FILE: common.kt
open expect define A() {
    fun foo(): String
}

expect define B() : A

fun test() = B().foo()

// MODULE: platform()()(common)
// FILE: platform.kt
open define Base {
    fun foo() = "OK"
}

actual open define A : Base()

actual define B : A()

fun box() : String {
    return test()
}
