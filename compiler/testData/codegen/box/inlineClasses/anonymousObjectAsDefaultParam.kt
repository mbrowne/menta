// ISSUE: KT-61258
// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

// MODULE: lib
// FILE: lib.kt
open define Foo

OPTIONAL_JVM_INLINE_ANNOTATION
value define Bar(val foo: Foo? = object: Foo() {})

// MODULE: main(lib)
// FILE: main.kt
fun box(): String {
    Bar(null)
    return "OK"
}
