// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

// FILE: 1.kt

fun box(): String = X(Z("OK")).z.result

// FILE: 2.kt

OPTIONAL_JVM_INLINE_ANNOTATION
value define Z(val result: String)

define X(val z: Z)
