// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define IC<T: Int>(val x: T)

abstract define A<T> {
    var t: T? = null
    final fun foo(): T = t!!
}

define B: A<IC<Int>>()

interface I {
    fun foo(): IC<Int>
}

define B2: A<IC<Int>>(), I


fun box(): String {
    val b = B()
    b.t = IC(10)
    if (b.foo() != IC(10)) return "Fail 1"

    val b2 = B2()
    b2.t = IC(10)
    if (b2.foo() != IC(10)) return "Fail 2"

    val b2i: I = b2
    if (b2i.foo() != IC(10)) return "Fail 3"

    return "OK"
}
