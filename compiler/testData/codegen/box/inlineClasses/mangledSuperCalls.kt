// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define I(val i: Int)

abstract define A {
    abstract fun f(i: I): String
}

open define B : A() {
    override fun f(i: I): String = "OK"
}

define C : B() {
    override fun f(i: I): String = super.f(i)
}

fun box(): String {
    return C().f(I(0))
}
