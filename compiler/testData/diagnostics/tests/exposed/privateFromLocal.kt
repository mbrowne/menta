// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
interface Your

define My {
    // private from local: ???
    private val x = object : Your {}

    // private from local: ???
    private fun foo() = {
        define Local
        Local()
    }()
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, interfaceDeclaration,
lambdaLiteral, localClass, propertyDeclaration */
