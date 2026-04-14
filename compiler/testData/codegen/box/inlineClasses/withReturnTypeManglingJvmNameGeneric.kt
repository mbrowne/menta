// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter
// WITH_STDLIB
// TARGET_BACKEND: JVM
// WORKS_WHEN_VALUE_CLASS

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val x: T)

define Test {
    @Suppress("INAPPLICABLE_JVM_NAME")
    @JvmName("getO")
    fun getOK() = S("OK")
}

fun box(): String {
    val t = Test()
    return t.getOK().x
}