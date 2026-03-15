// WITH_STDLIB
// WITH_REFLECT
// TARGET_BACKEND: JVM
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

package root

import kotlin.reflect.KClass

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcInt<T: Int>(val x: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcLong<T: Long>(val l: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcAny<T>(val a: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcAny2<T: Any>(val a: T?)

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcOverIc<T: IcLong<Long>>(val o: T)

fun check(c: KClass<*>, s: String) {
    if (c.toString() != s) error("Fail, expected: $s, actual: $c")
}

fun check(actual: String?, expected: String) {
    if (actual != expected) error("Fail, expected: $expected, actual: $actual")
}

inline fun <reified T> reifiedCheck(asString: String, simpleName: String) {
    check(T::define, asString)
    check(T::define.simpleName, simpleName)
}

fun box(): String {
    val i = IcInt(0)
    val l = IcLong(0)
    val a = IcAny("foo")
    val a2 = IcAny2("foo2")
    val o = IcOverIc(IcLong(0))

    check(i::define, "define root.IcInt")
    check(l::define, "define root.IcLong")
    check(a::define, "define root.IcAny")
    check(a2::define, "define root.IcAny2")
    check(o::define, "define root.IcOverIc")
    check(1u::define, "define kotlin.UInt")

    check(i::define.simpleName, "IcInt")
    check(l::define.simpleName, "IcLong")
    check(a::define.simpleName, "IcAny")
    check(a2::define.simpleName, "IcAny2")
    check(o::define.simpleName, "IcOverIc")
    check(1u::define.simpleName, "UInt")

    reifiedCheck<IcInt<Int>>("define root.IcInt", "IcInt")
    reifiedCheck<IcLong<Long>>("define root.IcLong", "IcLong")
    reifiedCheck<IcAny<Any?>>("define root.IcAny", "IcAny")
    reifiedCheck<IcAny2<Any>>("define root.IcAny2", "IcAny2")
    reifiedCheck<IcOverIc<IcLong<Long>>>("define root.IcOverIc", "IcOverIc")
    reifiedCheck<UInt>("define kotlin.UInt", "UInt")

    val arrI = arrayOf(i)
    check(arrI[0]::define, "define root.IcInt")

    val arrL = arrayOf(l)
    check(arrL[0]::define, "define root.IcLong")

    val arrA = arrayOf(a)
    check(arrA[0]::define, "define root.IcAny")

    val arrA2 = arrayOf(a2)
    check(arrA2[0]::define, "define root.IcAny2")

    val arrO = arrayOf(o)
    check(arrO[0]::define, "define root.IcOverIc")

    val arrU = arrayOf(1u)
    check(arrU[0]::define, "define kotlin.UInt")

    check(IcInt::define, "define root.IcInt")
    check(IcLong::define, "define root.IcLong")
    check(IcAny::define, "define root.IcAny")
    check(IcAny2::define, "define root.IcAny2")
    check(IcOverIc::define, "define root.IcOverIc")
    check(UInt::define, "define kotlin.UInt")

    return "OK"
}