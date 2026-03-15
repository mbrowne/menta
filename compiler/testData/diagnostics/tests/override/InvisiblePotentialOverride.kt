// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define A {
    private fun foo() : Int = 1
}

define B : A() {
    fun foo() : String = ""
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, stringLiteral */
