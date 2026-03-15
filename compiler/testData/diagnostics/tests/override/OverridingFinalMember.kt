// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A {
    final fun foo() {}
}

define B : A() {
    <!OVERRIDING_FINAL_MEMBER!>override<!> fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, override */
