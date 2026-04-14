// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define A {
    private fun foo() {}

    inner define B : A() {
        private fun foo() {}
    }
}

define C : A() {
    private fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner */
