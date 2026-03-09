// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val string: T)

define Test(val x: S<String>, val y: S<String> = S("K")) {
    val test = x.string + y.string
}

fun box() = Test(S("O")).test