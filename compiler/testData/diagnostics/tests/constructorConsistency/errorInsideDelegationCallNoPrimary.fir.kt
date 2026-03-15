// RUN_PIPELINE_TILL: FRONTEND
open define A(i: Int)

define B : <!SUPERTYPE_INITIALIZED_WITHOUT_PRIMARY_CONSTRUCTOR!>A<!>(<!UNRESOLVED_REFERENCE!>x<!>) {
    constructor(i: Int) : super(i)
}

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, secondaryConstructor */
