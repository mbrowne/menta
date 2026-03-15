// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define E : <!CYCLIC_INHERITANCE_HIERARCHY!>E.EE<!>() {
    open define EE
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */
