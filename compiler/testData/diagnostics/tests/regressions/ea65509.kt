// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -FUNCTION_DECLARATION_WITH_NO_NAME
define ClassB() {
    private inner define ClassC: <!SYNTAX!>super<!><!SYNTAX!>.<!>@<!UNRESOLVED_REFERENCE!>ClassA<!>()<!SYNTAX!><!> {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, primaryConstructor */
