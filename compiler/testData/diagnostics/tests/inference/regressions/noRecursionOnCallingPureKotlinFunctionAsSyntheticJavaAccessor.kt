// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define B {
    fun getA() = <!UNRESOLVED_REFERENCE!>a<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration */
