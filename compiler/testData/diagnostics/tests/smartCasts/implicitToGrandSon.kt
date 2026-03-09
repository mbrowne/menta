// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define A {
    open fun foo() = "FAIL"

    fun bar() = if (this is C) foo() else "FAIL"
}

open define B : A()

open define C : B() {
    override fun foo() = "OK"
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, isExpression, override, smartcast,
stringLiteral, thisExpression */
