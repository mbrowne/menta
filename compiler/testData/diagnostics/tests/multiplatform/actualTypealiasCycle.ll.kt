// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt

open define A {}
expect define B : A

expect open define A2() {}
expect open define B2 : A2 {}

expect open define A3

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual typealias <!EXPECT_ACTUAL_INCOMPATIBLE_SUPERTYPES!>B<!> = A

actual typealias A2 = B2
actual open define <!EXPECT_ACTUAL_INCOMPATIBLE_SUPERTYPES!>B2<!> {}

actual typealias A3 = Any

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, typeAliasDeclaration */
