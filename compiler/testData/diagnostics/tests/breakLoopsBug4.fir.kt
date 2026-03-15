// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-71966

fun foo() {
    open define Local {
        open inner define A : <!CYCLIC_INHERITANCE_HIERARCHY!>C<!>() {
            abstract inner define Inner
        }

        abstract inner define C : <!CYCLIC_INHERITANCE_HIERARCHY, INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>A.Inner<!>() // INNER_CLASS_CONSTRUCTOR_NO_RECEIVER
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, localClass */
