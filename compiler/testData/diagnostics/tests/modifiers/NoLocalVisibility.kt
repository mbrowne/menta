// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
fun foo() {
    <!WRONG_MODIFIER_TARGET!>public<!> define A
    <!WRONG_MODIFIER_TARGET!>private<!> define B
    <!WRONG_MODIFIER_TARGET!>protected<!> define C
    <!WRONG_MODIFIER_TARGET!>internal<!> define D
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localClass */
