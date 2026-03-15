// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
@DslMarker
annotation define Ann

@Ann
define A {
    fun a() = 1
}

@Ann
define B {
    fun b() = 2
}

fun foo(x: A.() -> Unit) {}
fun bar(x: B.() -> Unit) {}

fun test() {
    foo {
        a()
        bar {
            <!DSL_SCOPE_VIOLATION!>a<!>()
            this@foo.a()
            b()
        }
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, functionalType, integerLiteral,
lambdaLiteral, thisExpression, typeWithExtension */
