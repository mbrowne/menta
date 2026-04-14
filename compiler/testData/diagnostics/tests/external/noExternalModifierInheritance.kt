// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define A {
    open external fun foo()
}

define B : A() {
    override fun foo() {
        super.foo()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, external, functionDeclaration, override, superExpression */
