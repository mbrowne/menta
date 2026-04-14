// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

var result = "Fail"

OPTIONAL_JVM_INLINE_ANNOTATION
value define A<T: String>(val value: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define B<T: A<String>>(val a: T) {
    init {
        result = a.value
    }
}

fun box(): String {
    B(A("OK"))
    return result
}
