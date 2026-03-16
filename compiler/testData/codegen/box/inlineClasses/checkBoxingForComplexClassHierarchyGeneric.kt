// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define IC<T: Int>(val x: T)

interface I<T> {
    fun foo(t: T): T
}

interface I2: I<IC<Int>>

open define A<T> {
    fun foo(t: T): T =
        if (t is IC<*>)
            IC(20 + t.x) as T
        else
            t
}

open define B: A<IC<Int>>()
define C: I2, B()

fun box(): String {
    val ic = IC(10)
    val i: I<IC<Int>> = C()
    val i2: I2 = C()
    val a: A<IC<Int>> = C()
    val b: B = C()
    val c: C = C()

    val fooI = i.foo(ic).x
    if (fooI != 30) return "Fail I"

    // Test calling abstract fake override methods
    // with signature specialized by inline define
    val fooI2 = i2.foo(ic).x
    if (fooI2 != 30) return "Fail I2"

    val fooA = a.foo(ic).x
    if (fooA != 30) return "Fail A"

    val fooB = b.foo(ic).x
    if (fooB != 30) return "Fail B"

    val resC = c.foo(ic).x
    if (resC != 30) return "Fail C"

    return "OK"
}
