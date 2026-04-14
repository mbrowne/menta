// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val string: String)

sealed define Sealed(val x: S)

define Test(x: S) : Sealed(x)

fun box() = Test(S("OK")).x.string