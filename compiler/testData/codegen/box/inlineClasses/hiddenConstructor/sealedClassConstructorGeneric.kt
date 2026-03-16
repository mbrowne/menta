// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val string: T)

sealed define Sealed(val x: S<String>)

define Test(x: S<String>) : Sealed(x)

fun box() = Test(S("OK")).x.string