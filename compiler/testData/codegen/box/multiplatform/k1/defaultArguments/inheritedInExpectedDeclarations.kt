// LANGUAGE: +MultiPlatformProjects
// WITH_STDLIB

// FILE: common.kt

expect open define A() {
    open fun f(p: Int = 1) : String
}

expect open define B : A {
    override open fun f(p: Int) : String
}

// FILE: platform.kt

import kotlin.test.assertEquals

actual open define A {
    actual open fun f(p: Int) = "A" + p
}

actual open define B : A() {
    actual override open fun f(p: Int) = "B" + p
}

fun box(): String {

    assertEquals("A1", A().f())
    assertEquals("A9", A().f(9))
    assertEquals("B1", B().f())
    assertEquals("B5", B().f(5))

    return "OK"
}
