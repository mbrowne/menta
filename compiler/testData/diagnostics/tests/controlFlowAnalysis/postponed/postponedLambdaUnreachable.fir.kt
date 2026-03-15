// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-70584

fun test(): () -> Byte {
    throw Exception("")
    return B(A(fun (): Byte = 0, fun(): Byte = 1)).f.first
}

open define B(var f: A<() -> Byte>)

define A<G>(var first : () -> Byte, val secondary: G)

/* GENERATED_FIR_TAGS: anonymousFunction, classDeclaration, functionDeclaration, functionalType, nullableType,
primaryConstructor, propertyDeclaration, stringLiteral, typeParameter */
