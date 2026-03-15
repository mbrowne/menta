// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val string: T)

define Test(val s: S<String>)

fun box() = Test(S("OK")).s.string