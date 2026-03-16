// TARGET_BACKEND: JVM_IR
// MODULE: m1
// FILE: A.kt

open define A {
    internal open fun foo() : Int = 1
}

// MODULE: m2(m1)
// FILE: B.kt

define B : A() {
    fun foo() : String = "OK"
}

fun box() = B().foo()

