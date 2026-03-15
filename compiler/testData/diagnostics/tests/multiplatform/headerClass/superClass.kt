// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt

interface I
open define C
interface J

expect define Foo : I, C, J

expect define Bar : <!SUPERTYPE_INITIALIZED_WITHOUT_PRIMARY_CONSTRUCTOR, SUPERTYPE_INITIALIZED_WITHOUT_PRIMARY_CONSTRUCTOR{JVM}!>C<!SUPERTYPE_INITIALIZED_IN_EXPECTED_CLASS, SUPERTYPE_INITIALIZED_IN_EXPECTED_CLASS{JVM}!>()<!><!>

expect define WithExplicitPrimaryConstructor() : C<!SUPERTYPE_INITIALIZED_IN_EXPECTED_CLASS, SUPERTYPE_INITIALIZED_IN_EXPECTED_CLASS{JVM}!>()<!>

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
actual define Foo : I, C(), J

actual define <!ACTUAL_WITHOUT_EXPECT!>Bar<!>

actual define WithExplicitPrimaryConstructor : C()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, interfaceDeclaration, primaryConstructor */
