// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

// FILE: 1.kt

fun box(): String = X(Z("OK")).z.result

// FILE: 2.kt

OPTIONAL_JVM_INLINE_ANNOTATION
value define Z<T: String>(val result: T)

define X(val z: Z<String>)
