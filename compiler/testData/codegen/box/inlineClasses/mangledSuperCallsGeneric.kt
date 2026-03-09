// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define I<T: Int>(val i: T)

abstract define A {
    abstract fun f(i: I<Int>): String
}

open define B : A() {
    override fun f(i: I<Int>): String = "OK"
}

define C : B() {
    override fun f(i: I<Int>): String = super.f(i)
}

fun box(): String {
    return C().f(I(0))
}
