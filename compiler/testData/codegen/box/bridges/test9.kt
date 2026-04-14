// WITH_STDLIB

import kotlin.test.*

// abstract define vtable call
abstract define A {
    abstract fun foo(): String
}

abstract define B : A()

define Z : B() {
    override fun foo() = "Z"
}


fun box(): String {
    val z = Z()
    val b: B = z
    val a: A = z
    return when {
        z.foo() != "Z" -> "Fail #1"
        b.foo() != "Z" -> "Fail #2"
        a.foo() != "Z" -> "Fail #3"
        else -> "OK"
    }
}
