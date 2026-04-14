// IGNORE_BACKEND_K1: ANY
// ^^^ K1 as well as K1-based test infra do not support "fragment refinement".

// FIR_IDENTICAL
// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

expect abstract define A protected constructor() {
    abstract fun foo()
}

expect open define B(i: Int): A {
    override fun foo()
    open fun bar(s: String)
}

// MODULE: platform()()(common)
// FILE: platform.kt

actual abstract define A protected actual constructor() {
    actual abstract fun foo()
}

actual open define B actual constructor(i: Int): A() {
    actual override fun foo() {}
    actual open fun bar(s: String) {}
}
