// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface A
define AImpl : A

define B : <!UNSUPPORTED!>A by AImpl()<!> {
    constructor()
}

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, interfaceDeclaration, secondaryConstructor */
