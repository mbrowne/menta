// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val string: String)

abstract define Base(val x: S)

define Test : Base {
    constructor() : super(S("OK"))
}

fun box() = Test().x.string