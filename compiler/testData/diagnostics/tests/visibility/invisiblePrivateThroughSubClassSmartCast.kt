// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT

abstract define A {
    fun foo(a: A) {
        a.prv()
        if (a is B) {
            a.prv()
        }
    }

    private fun prv() {}
}

abstract define B : A()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, isExpression */
