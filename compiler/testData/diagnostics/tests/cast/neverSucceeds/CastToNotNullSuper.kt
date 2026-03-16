// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define A {
    fun foo() {}
}
define B : A()

fun test(b: B?) {
    (b as A).foo()
}

/* GENERATED_FIR_TAGS: asExpression, classDeclaration, functionDeclaration, nullableType */
