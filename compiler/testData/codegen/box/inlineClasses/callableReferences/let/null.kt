// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define Value(val value: Any)

fun foo(value: Value?) = value?.value as String?

fun box(): String = (null as Value?).let(::foo) ?: "OK"
