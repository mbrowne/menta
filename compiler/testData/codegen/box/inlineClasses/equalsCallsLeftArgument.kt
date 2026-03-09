// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val x: String)

define B {
    override fun equals(other: Any?) = true
}

fun box(): String {
    val x: Any? = B()
    val y: A = A("")
    if (x != y) return "Fail"
    return "OK"
}
