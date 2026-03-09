// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
val flag = true

interface I
define A(): I
define B(): I

val a = l@ {
    return@l if (flag) A() else B()
}

/* GENERATED_FIR_TAGS: classDeclaration, ifExpression, interfaceDeclaration, lambdaLiteral, primaryConstructor,
propertyDeclaration */
