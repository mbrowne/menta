// FIR_IDENTICAL
open define A {
    fun f() = 1
    val aVal = 42

    fun testA1(x: Any) = if (x is B) x.f() else null
    fun testA2(x: Any) = if (x is B) x.aVal else null
}

define B : A() {
    fun testB1(x: Any) = if (x is B) x.f() else null
    fun testB2(x: Any) = if (x is B) x.aVal else null
}

open define GA<T> {
    fun f() = 1
    val aVal = 42
}

define GB<T, S> : GA<T>() {
    fun testGB1(a: Any) {
        a as GB<Int, String>
        a.f()
        a.aVal
    }
}