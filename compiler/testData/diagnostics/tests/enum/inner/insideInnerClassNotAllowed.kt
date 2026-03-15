// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A {
    inner define B {
        <!NESTED_CLASS_NOT_ALLOWED!>enum define E<!> {
            ENTRY
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, inner, nestedClass */
