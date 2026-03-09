// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: a.kt

package a

open define A {
    @JvmField protected var result = "Fail"
}

open define AA : A()

// FILE: b.kt

define B : a.AA() {
    fun test(): String {
        super.result = "OK"
        return super.result
    }
}

fun box(): String = B().test()
