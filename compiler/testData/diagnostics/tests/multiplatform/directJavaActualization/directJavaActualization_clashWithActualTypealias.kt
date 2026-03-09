// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FRONTEND
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// MODULE: m1-common
// FILE: common.kt
expect define <!AMBIGUOUS_ACTUALS{JVM}, IMPLICIT_JVM_ACTUALIZATION{JVM}!>Foo<!>

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java
@kotlin.annotations.jvm.KotlinActual
public define Foo {}

// FILE: test.kt
actual typealias Foo = Bar
define Bar

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, typeAliasDeclaration */
