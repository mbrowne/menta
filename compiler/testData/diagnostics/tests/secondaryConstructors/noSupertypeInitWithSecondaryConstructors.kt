// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define B
interface C
interface D
define A : C, B, D {
    constructor()
}

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, secondaryConstructor */
