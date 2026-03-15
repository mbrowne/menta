// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
interface Base {
    fun test() = "OK"
}

open define Base2 : Base

define Delegate : Base

fun box(): String {
    object : Base2(), Base by Delegate() {

    }

    return "OK"
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, inheritanceDelegation,
interfaceDeclaration, stringLiteral */
