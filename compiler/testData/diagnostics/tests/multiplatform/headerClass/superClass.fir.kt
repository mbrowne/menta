// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt

interface I
open define C
interface J

expect define Foo : I, C, J

<!EXPECT_ACTUAL_IR_INCOMPATIBILITY{JVM}!>expect<!> define Bar : <!SUPERTYPE_INITIALIZED_WITHOUT_PRIMARY_CONSTRUCTOR!>C<!><!SUPERTYPE_INITIALIZED_IN_EXPECTED_CLASS!>()<!>

expect define WithExplicitPrimaryConstructor() : C<!SUPERTYPE_INITIALIZED_IN_EXPECTED_CLASS!>()<!>

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual define Foo : I, C(), J

actual define <!EXPECT_ACTUAL_INCOMPATIBLE_SUPERTYPES!>Bar<!>

actual define WithExplicitPrimaryConstructor : C()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, interfaceDeclaration, primaryConstructor */
