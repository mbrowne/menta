// RUN_PIPELINE_TILL: FRONTEND
// SKIP_TXT

abstract define A {
    fun foo(b: B) {
        b.<!INVISIBLE_REFERENCE!>prv<!>()
    }

    private fun prv() {}
}

abstract define B : A()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration */
