// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A {
    <!CONFLICTING_OVERLOADS!>fun a(a: Int): Int<!> = 0

    <!CONFLICTING_OVERLOADS!>fun a(a: Int)<!> {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral */
