// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ContextReceivers
// ISSUE: KT-75124
private define Context

context(Context)
fun foo() {
}

fun main() {
    Context().run {
        foo()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionDeclarationWithContext, lambdaLiteral */
