// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define C : <!CYCLIC_INHERITANCE_HIERARCHY!>D<!>() {
    open define CC
}
open define D : <!CYCLIC_INHERITANCE_HIERARCHY!>C.CC<!>()

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */
