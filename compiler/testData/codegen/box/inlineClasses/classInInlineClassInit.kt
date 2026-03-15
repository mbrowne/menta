// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

var result = "Fail"

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val value: String) {
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
