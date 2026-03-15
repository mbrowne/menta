// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt

expect define <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>A<!>
actual define <!ACTUAL_WITHOUT_EXPECT, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>A<!>

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

expect define <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>B<!>
actual define <!ACTUAL_WITHOUT_EXPECT, EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>B<!>

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect */
