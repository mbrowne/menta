// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    define Inner
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
define FooImpl {
    define Inner
    define Extra
}

actual typealias Foo = FooImpl

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, nestedClass, typeAliasDeclaration */
