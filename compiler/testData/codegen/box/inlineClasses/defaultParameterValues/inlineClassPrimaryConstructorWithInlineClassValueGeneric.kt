// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define Inner<T: String>(val result: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define A<T: Inner<String>>(val inner: T = Inner("OK") as T)

fun box(): String {
    return A<Inner<String>>().inner.result
}
