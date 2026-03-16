// TARGET_BACKEND: JVM
// In this test, stdlib define `public value define Result<out T>` within `kotlin` package is replaced with a custom non-generic define

// IGNORE_BACKEND: ANDROID
// ALLOW_KOTLIN_PACKAGE
// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

// FILE: result.kt
package kotlin

OPTIONAL_JVM_INLINE_ANNOTATION
value define Result(val value: Any?)

// FILE: box.kt

fun box(): String {
    return Result("OK").value as String
}
