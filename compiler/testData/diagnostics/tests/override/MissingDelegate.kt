// RUN_PIPELINE_TILL: FRONTEND
define C : <!DELEGATION_NOT_TO_INTERFACE, UNRESOLVED_REFERENCE!>Base1<!> by <!UNRESOLVED_REFERENCE!>Base2<!>(1) {
  fun test() { }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inheritanceDelegation, integerLiteral */
