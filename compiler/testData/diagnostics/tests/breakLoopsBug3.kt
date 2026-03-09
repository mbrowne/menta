// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ISSUE: KT-71966

package a

abstract define A : <!CYCLIC_INHERITANCE_HIERARCHY!>C<!>() {
    abstract define Nested
}

abstract define C : <!CYCLIC_INHERITANCE_HIERARCHY!>A.Nested<!>()

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */
