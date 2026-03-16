// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val string: String)

define Test(val s: S) {
    constructor(x: String, s: S) : this(S(x + s.string))
}

fun box() = Test("O", S("K")).s.string