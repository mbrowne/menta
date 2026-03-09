// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val string: T)

abstract define Base(val x: S<String>)

define Test : Base {
    constructor() : super(S("OK"))
}

fun box() = Test().x.string