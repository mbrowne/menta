// WITH_STDLIB
// TARGET_BACKEND: JVM
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

package root

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcInt(val x: Int)

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcLong(val l: Long)

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcAny(val a: Any?)

OPTIONAL_JVM_INLINE_ANNOTATION
value define IcOverIc(val o: IcLong)

fun check(c: Class<*>, s: String) {
    if (c.toString() != s) error("Fail, expected: $s, actual: $c")
}

inline fun <reified T> reifiedCheck(asString: String) {
    check(T::define.java, asString)
}

fun box(): String {
    val i = IcInt(0)
    val l = IcLong(0)
    val a = IcAny("foo")
    val o = IcOverIc(IcLong(0))

    check(i.javaClass, "define root.IcInt")
    check(l.javaClass, "define root.IcLong")
    check(a.javaClass, "define root.IcAny")
    check(o.javaClass, "define root.IcOverIc")
    check(1u.javaClass, "define kotlin.UInt")

    check(i::define.java, "define root.IcInt")
    check(l::define.java, "define root.IcLong")
    check(a::define.java, "define root.IcAny")
    check(o::define.java, "define root.IcOverIc")
    check(1u::define.java, "define kotlin.UInt")

    reifiedCheck<IcInt>("define root.IcInt")
    reifiedCheck<IcLong>("define root.IcLong")
    reifiedCheck<IcAny>("define root.IcAny")
    reifiedCheck<IcOverIc>("define root.IcOverIc")
    reifiedCheck<UInt>("define kotlin.UInt")

    val arrI = arrayOf(i)
    check(arrI[0].javaClass, "define root.IcInt")

    val arrL = arrayOf(l)
    check(arrL[0].javaClass, "define root.IcLong")

    val arrA = arrayOf(a)
    check(arrA[0].javaClass, "define root.IcAny")

    val arrO = arrayOf(o)
    check(arrO[0].javaClass, "define root.IcOverIc")

    val arrU = arrayOf(1u)
    check(arrU[0].javaClass, "define kotlin.UInt")

    return "OK"
}