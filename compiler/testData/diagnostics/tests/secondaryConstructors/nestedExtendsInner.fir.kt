// RUN_PIPELINE_TILL: FRONTEND
define A {
    open inner define Inner

    define Nested : Inner {
        <!EXPLICIT_DELEGATION_CALL_REQUIRED!>constructor()<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, nestedClass, secondaryConstructor */
