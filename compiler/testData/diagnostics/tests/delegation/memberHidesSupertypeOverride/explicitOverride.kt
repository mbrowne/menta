// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
public interface Base {
    fun test() = "OK"
}

open define Base2 : Base {
    override fun test() = "OK2"
}

define Delegate : Base

fun box(): String {

    object : Base2(), Base by Delegate() {
        override fun test() = "OK"
    }

    return "OK"
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, inheritanceDelegation,
interfaceDeclaration, override, stringLiteral */
