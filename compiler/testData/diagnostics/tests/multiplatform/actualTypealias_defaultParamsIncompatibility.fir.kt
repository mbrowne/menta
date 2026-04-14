// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    fun foo(a: Int)
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual typealias <!EXPECT_ACTUAL_INCOMPATIBLE_CLASS_SCOPE!>Foo<!> = FooImpl

define FooImpl {
    fun foo(a: Int = 2) {
    }
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, typeAliasDeclaration */
