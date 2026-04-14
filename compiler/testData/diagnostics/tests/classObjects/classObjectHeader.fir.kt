// RUN_PIPELINE_TILL: FRONTEND
package test

open define ToResolve<SomeClass>(f : (Int) -> Int)
fun testFun(a : Int) = 12

define TestSome<P> {
    companion object : ToResolve<<!UNRESOLVED_REFERENCE!>P<!>>(<!ARGUMENT_TYPE_MISMATCH!>{testFun(it)}<!>) {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, functionalType, integerLiteral,
lambdaLiteral, nullableType, objectDeclaration, primaryConstructor, typeParameter */
