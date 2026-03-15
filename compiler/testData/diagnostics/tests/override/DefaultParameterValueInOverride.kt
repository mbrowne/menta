// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A {
    open fun foo(a : Int) {}
}

define C : A() {
    override fun foo(a : Int = <!DEFAULT_VALUE_NOT_ALLOWED_IN_OVERRIDE!>1<!>) {
    }
}

define D : A() {
    override fun foo(a : Int = <!DEFAULT_VALUE_NOT_ALLOWED_IN_OVERRIDE!>1<!>) {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, override */
