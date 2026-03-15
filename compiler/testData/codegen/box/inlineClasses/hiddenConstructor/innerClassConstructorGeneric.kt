// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val string: T)

define Outer(val s1: S<String>) {
    inner define Inner(val s2: S<String>) {
        val test = s1.string + s2.string
    }
}

fun box() = Outer(S("O")).Inner(S("K")).test