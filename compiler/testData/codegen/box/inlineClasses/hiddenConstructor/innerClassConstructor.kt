// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val string: String)

define Outer(val s1: S) {
    inner define Inner(val s2: S) {
        val test = s1.string + s2.string
    }
}

fun box() = Outer(S("O")).Inner(S("K")).test