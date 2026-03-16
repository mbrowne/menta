// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

define C2 : C1() {
    override fun o() = super.o()

    override val k = "K"
}

expect open define C1() {
    open fun o(): String

    open val k: String
}

fun foo(c2: C2) = c2.o() + c2.k

// MODULE: platform()()(common)
// FILE: platform.kt

actual open define C1 {
    actual open fun o() = "O"

    actual open val k = "K"
}

fun box() = foo(C2())
