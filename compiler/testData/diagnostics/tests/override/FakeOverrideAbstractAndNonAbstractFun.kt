// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define Ccc() {
    fun foo() = 1
}

interface Ttt {
    fun foo(): Int
}

define Zzz() : Ccc(), Ttt

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration, primaryConstructor */
