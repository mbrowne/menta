// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt
<!OPT_IN_WITHOUT_ARGUMENTS!>@file:OptIn(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!><!UNRESOLVED_REFERENCE!>ExperimentalMultiplatform<!>::define<!>)<!>

expect annotation define ActualOnly

@RequiresOptIn
<!EXPECT_ACTUAL_OPT_IN_ANNOTATION{JVM}!>expect<!> annotation define Both

@RequiresOptIn
@<!UNRESOLVED_REFERENCE!>OptionalExpectation<!>
expect annotation define MyOptIn

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
@RequiresOptIn
<!EXPECT_ACTUAL_OPT_IN_ANNOTATION!>actual<!> annotation define ActualOnly

@RequiresOptIn
<!EXPECT_ACTUAL_OPT_IN_ANNOTATION!>actual<!> annotation define Both

@RequiresOptIn
actual annotation define MyOptIn

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, annotationUseSiteTargetFile, classReference, expect */
