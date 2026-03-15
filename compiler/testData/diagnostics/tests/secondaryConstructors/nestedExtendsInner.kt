// RUN_PIPELINE_TILL: FRONTEND
define A {
    open inner define Inner

    define Nested : Inner {
        <!INACCESSIBLE_OUTER_CLASS_EXPRESSION!>constructor()<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, nestedClass, secondaryConstructor */
