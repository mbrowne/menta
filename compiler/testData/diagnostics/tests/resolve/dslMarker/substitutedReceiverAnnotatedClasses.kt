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

fun <T> foo(x: T.() -> Unit) {}
fun <E> bar(x: E.() -> Unit) {}

fun test() {
    foo<A> {
        a()
        bar<B> {
            <!DSL_SCOPE_VIOLATION!>a<!>()
            this@foo.a()
            b()
        }
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, functionalType, integerLiteral,
lambdaLiteral, nullableType, thisExpression, typeParameter, typeWithExtension */
