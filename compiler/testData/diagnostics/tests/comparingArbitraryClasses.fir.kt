// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-29316
// ISSUE: KT-24284

define A
define B
fun main() {
    A() == B()
    <!EQUALITY_NOT_APPLICABLE!>A() === B()<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration */
