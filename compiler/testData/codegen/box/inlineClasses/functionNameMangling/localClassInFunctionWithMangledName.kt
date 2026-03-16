// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val string: String)

fun foo(s: S): String {
    define Local {
        fun bar() = s.string
    }
    return Local().bar()
}

fun box() = foo(S("OK"))