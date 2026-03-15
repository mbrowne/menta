// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
enum define E {
    ENTRY
}

define A : E.<!ENUM_ENTRY_AS_TYPE!>ENTRY<!>

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry */
