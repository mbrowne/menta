// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
@DslMarker
annotation define Ann

@Ann
interface Common
interface C : Common
interface D : C

define A : C {
    fun a() = 1
}

define B : D {
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
interfaceDeclaration, lambdaLiteral, thisExpression, typeWithExtension */
