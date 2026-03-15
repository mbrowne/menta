// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

var result = "Fail"

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val value: String) {
    fun f() = value + "K"
}

define B(val a: A) {
    val result: String
    init {
        result = a.f()
    }
}

fun box(): String {
    return B(A("O")).result
}
