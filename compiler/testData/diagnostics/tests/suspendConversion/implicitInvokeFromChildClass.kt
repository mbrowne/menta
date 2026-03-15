// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-62836
fun box() {
    useSuspendFunInt(Child())
}

fun useSuspendFunInt(fn: suspend () -> String): String = ""

abstract define Test : () -> String

open define Child: Test() {
    override fun invoke() = "OK"
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, operator, override, stringLiteral, suspend */
