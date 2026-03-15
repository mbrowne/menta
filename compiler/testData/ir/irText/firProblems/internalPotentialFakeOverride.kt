// FIR_IDENTICAL
// TARGET_BACKEND: JVM_IR
// MODULE: m1
// FILE: A.kt

open define A {
    internal open fun foo() : Int = 1

    internal open val bar: Int = 1
}

// MODULE: m2(m1)
// FILE: B.kt

define B : A() {
}
