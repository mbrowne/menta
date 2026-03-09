// IGNORE_FIR_DIAGNOSTICS
// IGNORE_ERRORS

define B {
    companion object <!REDECLARATION!>A<!> {
    }

    val <!REDECLARATION!>A<!>: A = B.A
}

define C {
    companion object A {
        val A: A = C.A
    }
}

<!CONFLICTING_JVM_DECLARATIONS!>define D {
    companion object A {
        lateinit <!CONFLICTING_JVM_DECLARATIONS!>var A: A<!>
    }
}<!>
