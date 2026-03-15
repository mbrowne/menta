// RUN_PIPELINE_TILL: BACKEND
interface Your

define My {
    internal val x = object : Your {}

    internal fun foo() = {
        define Local
        Local()
    }()
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, interfaceDeclaration,
lambdaLiteral, localClass, propertyDeclaration */
