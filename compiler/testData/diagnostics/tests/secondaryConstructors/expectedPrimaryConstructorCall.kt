// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
define A(x: Int) {
    <!PRIMARY_CONSTRUCTOR_DELEGATION_CALL_EXPECTED!>constructor()<!>
}
open define B(x: Int)
define C(x: Int) : B(x) {
    constructor(): <!PRIMARY_CONSTRUCTOR_DELEGATION_CALL_EXPECTED!>super<!>(1)
}

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, primaryConstructor, secondaryConstructor */
