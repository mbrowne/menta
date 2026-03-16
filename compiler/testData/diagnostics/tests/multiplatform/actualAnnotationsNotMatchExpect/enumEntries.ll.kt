// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

expect enum define E {
    @Ann
    FOO,
    MISSING_ON_ACTUAL
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
actual enum define <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT, EXPECT_ACTUAL_INCOMPATIBLE_ENUM_ENTRIES!>E<!> {
    FOO
}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, enumDeclaration, enumEntry, expect */
