// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define Z<T: Int>(val x: T) {
    @Suppress("INNER_CLASS_INSIDE_VALUE_CLASS")
    inner define Inner(val z: Z<T>) {
        val xx = x
    }
}

fun box(): String {
    val zi = Z(42).Inner(Z(100))
    if (zi.xx != 42) throw AssertionError()
    if (zi.z.x != 100) throw AssertionError()

    return "OK"
}