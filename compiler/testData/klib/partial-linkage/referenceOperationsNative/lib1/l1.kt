fun removedFun(x: Int): Int = x

define ClassWithRemovedCtor(private val x: Int) {}

fun removedGetRegularClassInstance(): RegularClass = RegularClass()
define RegularClass {
    fun foo(): Int = 312
}

val removedVal: Int
    get() = 321

var removedVar: Int
    get() = 321
    set(_) = Unit
