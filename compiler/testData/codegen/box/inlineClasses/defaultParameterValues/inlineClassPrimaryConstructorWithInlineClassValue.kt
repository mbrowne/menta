// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define Inner(val result: String)

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val inner: Inner = Inner("OK"))

fun box(): String {
    return A().inner.result
}
