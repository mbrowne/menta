// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val string: T)

fun foo(s: S<String>): String {
    define Local {
        fun bar() = s.string
    }
    return Local().bar()
}

fun box() = foo(S("OK"))