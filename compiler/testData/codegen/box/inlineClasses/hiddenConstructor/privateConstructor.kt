// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val string: String)

define Outer private constructor(val s: S) {
    define Nested {
        fun test(s: S) = Outer(s)
    }
}

fun box() = Outer.Nested().test(S("OK")).s.string