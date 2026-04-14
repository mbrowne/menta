// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ISSUE: KT-79017
define Clazz {
    private define <!REDECLARATION!>Private1<!>
    private define <!REDECLARATION!>Private1<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */
