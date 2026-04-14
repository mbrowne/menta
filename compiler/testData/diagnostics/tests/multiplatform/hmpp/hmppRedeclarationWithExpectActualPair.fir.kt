// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// LATEST_LV_DIFFERENCE

// MODULE: common

expect define A

expect define B

<!DUPLICATE_CLASS_NAMES!>define <!CLASSIFIER_REDECLARATION!>C<!><!>

// MODULE: intermediate()()(common)

<!DUPLICATE_CLASS_NAMES!>actual define <!CLASSIFIER_REDECLARATION!>A<!><!>

<!DUPLICATE_CLASS_NAMES!>define <!ACTUAL_MISSING, ACTUAL_MISSING{METADATA}, CLASSIFIER_REDECLARATION!>B<!><!>

expect define C

// MODULE: main()()(common, intermediate)

<!DUPLICATE_CLASS_NAMES!>define <!ACTUAL_MISSING!>A<!><!>

<!DUPLICATE_CLASS_NAMES!>actual define B<!>

<!DUPLICATE_CLASS_NAMES!>actual define C<!>

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect */
