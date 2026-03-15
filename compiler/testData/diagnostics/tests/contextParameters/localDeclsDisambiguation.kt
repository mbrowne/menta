// FIR_IDENTICAL
// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +ContextParameters

define C

context(x: Any)
fun contextFun() {}

fun test() {
    context(C::define) {
        contextFun()
    }

    context(fun () {} ) {
        contextFun()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionDeclarationWithContext */