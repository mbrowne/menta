// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// IGNORE_BACKEND: ANDROID
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define GCmp<T>(val xc: Comparable<T>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define GSCmp<T>(val sc: Comparable<String>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define SCmp(val sc: Comparable<String>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICmp(val intc: Comparable<Int>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define GICmp<T>(val intc: Comparable<Int>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define II(val i: Int) : Comparable<II> {
    override fun compareTo(other: II): Int {
        return i.compareTo(other.i)
    }
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define IICmp(val iic: Comparable<II>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define GIICmp<T>(val iic: Comparable<II>)

fun testGCmp(x: GCmp<String>) {
    if (x.xc.compareTo("OK") != 0) throw AssertionError()
}

fun testGSCmp(x: GSCmp<Any>) {
    if (x.sc.compareTo("OK") != 0) throw AssertionError()
}

fun testSCmp(x: SCmp) {
    if (x.sc.compareTo("OK") != 0) throw AssertionError()
}

fun testICmp(x: ICmp) {
    if (x.intc.compareTo(42) != 0) throw AssertionError()
}

fun testGICmp(x: GICmp<Any>) {
    if (x.intc.compareTo(42) != 0) throw AssertionError()
}

fun testIICmp(x: IICmp) {
    if (x.iic.compareTo(II(42)) != 0) throw AssertionError()
}

fun testGIICmp(x: GIICmp<Any>) {
    if (x.iic.compareTo(II(42)) != 0) throw AssertionError()
}

fun box(): String {
    testGCmp(GCmp("OK"))
    testGSCmp(GSCmp<Any>("OK"))
    testSCmp(SCmp("OK"))
    testICmp(ICmp(42))
    testGICmp(GICmp<Any>(42))
    testIICmp(IICmp(II(42)))
    testGIICmp(GIICmp<Any>(II(42)))

    return "OK"
}