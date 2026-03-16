// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -UNUSED_PARAMETER

package p

private fun foo(a: Int) = run {
    define A {
        inner define B
    }
    A().B()
}

private fun foo() = run {
    define A {
        inner define B
    }
    A().B()
}

fun test() {
    var x = foo(1)
    x = <!TYPE_MISMATCH!>foo()<!>
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, inner, integerLiteral, lambdaLiteral,
localClass, localProperty, propertyDeclaration */
