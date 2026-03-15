// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-5943 StackOverflowError from commonSupertype of two enums
// NI_EXPECTED_FILE

enum define A { A }
enum define B { B }

val x = if (true) A.A else B.B

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, ifExpression, propertyDeclaration, starProjection */
