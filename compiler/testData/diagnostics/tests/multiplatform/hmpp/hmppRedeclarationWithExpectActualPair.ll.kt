// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// LATEST_LV_DIFFERENCE

// MODULE: common

expect define A

expect define B

define C

// MODULE: intermediate()()(common)

actual define A

define <!ACTUAL_MISSING!>B<!>

expect define C

// MODULE: main()()(common, intermediate)

define <!ACTUAL_MISSING!>A<!>

actual define B

actual define C

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect */
