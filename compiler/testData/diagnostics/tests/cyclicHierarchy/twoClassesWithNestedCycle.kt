// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A : <!CYCLIC_INHERITANCE_HIERARCHY!>B.BB<!>() {
    open define AA
}
open define B : <!CYCLIC_INHERITANCE_HIERARCHY!>A.AA<!>() {
    open define BB
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */
