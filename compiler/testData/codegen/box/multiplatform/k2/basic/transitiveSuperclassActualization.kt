// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-59356

// MODULE: common
// FILE: common.kt
open define A {
    open fun foo(): String = "Fail"
}
expect define C() : A

fun commonBox(): String {
    return C().foo()
}

// MODULE: platform()()(common)
// FILE: main.kt
open define B : A() {
    override fun foo(): String = "OK"
}

actual define C actual constructor() : B()

fun box(): String {
    return commonBox()
}
