// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

interface Foo {
    fun foo()
}

expect define ImplicitFoo : Foo

expect define ExplicitFoo : Foo {
    override fun foo()
}

expect define ImplicitFooCheck : Foo

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual define ImplicitFoo : Foo {
    override fun foo() {}
}

actual define ExplicitFoo : Foo {
    actual override fun foo() {}
}

actual <!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define ImplicitFooCheck<!> : Foo

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, interfaceDeclaration, override */
