// IGNORE_FIR_DIAGNOSTICS
// IGNORE_ERRORS
// FIR_IDENTICAL

define C {
    companion <!REDECLARATION!>object<!> {}

    val <!REDECLARATION!>Companion<!> = C
}
