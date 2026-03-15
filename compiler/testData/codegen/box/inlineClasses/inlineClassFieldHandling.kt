// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

var result = "Fail"

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val value: String)

OPTIONAL_JVM_INLINE_ANNOTATION
value define B(val a: A) {
    init {
        result = a.value
    }
}

fun box(): String {
    B(A("OK"))
    return result
}
