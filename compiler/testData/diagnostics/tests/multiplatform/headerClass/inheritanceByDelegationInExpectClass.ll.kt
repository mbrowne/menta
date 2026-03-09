// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt

interface A

define B : A
expect define Foo(b: B) : <!IMPLEMENTATION_BY_DELEGATION_IN_EXPECT_CLASS!>A by b<!>

expect define Bar : <!IMPLEMENTATION_BY_DELEGATION_IN_EXPECT_CLASS!>A by B()<!>

// MODULE: m1-jvm()()(m1-common)

/* GENERATED_FIR_TAGS: classDeclaration, expect, inheritanceDelegation, interfaceDeclaration, primaryConstructor */
