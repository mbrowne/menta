// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
interface Base {
    fun f() = 1
}
    
open define Left() : Base

interface Right : Base

define Diamond() : Left(), Right

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration, primaryConstructor */
