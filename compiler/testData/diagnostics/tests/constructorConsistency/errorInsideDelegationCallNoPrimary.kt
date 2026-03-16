// RUN_PIPELINE_TILL: FRONTEND
open define A(i: Int)

define B : <!SUPERTYPE_INITIALIZED_WITHOUT_PRIMARY_CONSTRUCTOR!>A(<!DEBUG_INFO_MISSING_UNRESOLVED!>x<!>)<!> {
    constructor(i: Int) : super(i)
}

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, secondaryConstructor */
