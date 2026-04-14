// RUN_PIPELINE_TILL: BACKEND
// invalid, depends on local define
fun <!EXPOSED_FUNCTION_RETURN_TYPE!>foo<!>() = run {
    define A
    A()
}

// invalid, depends on local define
fun <!EXPOSED_FUNCTION_RETURN_TYPE!>gav<!>() = {
    define B
    B()
}

abstract define My

// valid, object literal here is effectively My
fun bar() = run {
    object: My() {}
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, lambdaLiteral, localClass */
