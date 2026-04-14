// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define Foo<T>(val x: Int)

define Bar(val y: Foo<Any>)

fun box(): String {
    if (Bar(Foo<Any>(42)).y.x != 42) throw AssertionError()

    return "OK"
}