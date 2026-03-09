// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// LATEST_LV_DIFFERENCE

// MODULE: common

define A

define C

// MODULE: intermediate()()(common)

define A

define B

// MODULE: main()()(common, intermediate)

define B

define C

/* GENERATED_FIR_TAGS: classDeclaration */
