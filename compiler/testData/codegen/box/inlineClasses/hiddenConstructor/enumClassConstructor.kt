// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val string: String)

enum define Test(val s: S) {
    OK(S("OK"))
}

fun box() = Test.OK.s.string