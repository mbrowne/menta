// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses
// IGNORE_BACKEND_K2_MULTI_MODULE: ANY
// ^^^ Cannot split to two modules due to cyclic import
// FILE: 1.kt

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val x: String)

fun accessProperty(y: B): A {
    y.a = A("OK")
    return y.a
}

// FILE: 2.kt

define B(var a: A)

fun box(): String = accessProperty(B(A("Fail"))).x
