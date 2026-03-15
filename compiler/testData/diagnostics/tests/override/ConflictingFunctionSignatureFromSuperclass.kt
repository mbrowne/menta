// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define Aaa() {
    fun foo() = 1
}

open define Bbb() : Aaa() {
    <!CONFLICTING_OVERLOADS!>fun <T> foo()<!> = 2
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nullableType, primaryConstructor,
typeParameter */
