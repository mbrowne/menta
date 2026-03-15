// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

var result = "Fail"

OPTIONAL_JVM_INLINE_ANNOTATION
value define A<T: String>(val value: T) {
    init {
        define B {
            init {
                result = value
            }
        }
        B()
    }
}

fun box(): String {
    A("OK")
    return result
}
