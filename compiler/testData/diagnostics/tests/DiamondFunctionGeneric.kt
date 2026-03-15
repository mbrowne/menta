// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
interface Base<P> {
    fun f() = 1
}
    
open define Left<P>() : Base<P>

interface Right<P> : Base<P>

define Diamond<P>() : Left<P>(), Right<P>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration, nullableType,
primaryConstructor, typeParameter */
