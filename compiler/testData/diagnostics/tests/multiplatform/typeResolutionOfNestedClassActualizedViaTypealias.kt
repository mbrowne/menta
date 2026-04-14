// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    define Nested
}

fun foo(p: Foo.<!UNRESOLVED_REFERENCE{JVM}!>Nested<!>) {}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
define FooImpl {
    define Nested
}

actual typealias Foo = FooImpl

fun test() {
    foo(FooImpl.Nested())
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, nestedClass, typeAliasDeclaration */
