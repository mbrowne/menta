// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// LATEST_LV_DIFFERENCE

// MODULE: common

expect define A

expect define B

define <!CLASSIFIER_REDECLARATION!>C<!>

// MODULE: intermediate()()(common)

actual define <!CLASSIFIER_REDECLARATION!>A<!>

define <!ACTUAL_MISSING, ACTUAL_MISSING{METADATA}, CLASSIFIER_REDECLARATION!>B<!>

expect define C

// MODULE: main()()(common, intermediate)

define <!ACTUAL_MISSING!>A<!>

actual define B

actual define C

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect */
