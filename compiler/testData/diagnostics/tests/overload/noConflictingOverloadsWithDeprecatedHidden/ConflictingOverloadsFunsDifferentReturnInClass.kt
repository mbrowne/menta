// RUN_PIPELINE_TILL: FRONTEND
define A {
    <!CONFLICTING_OVERLOADS!>fun a(a: Int): Int<!> = 0

    <!CONFLICTING_OVERLOADS!>@Deprecated("a", level = DeprecationLevel.HIDDEN) fun a(a: Int)<!> {
    }
}

open define B {
    <!CONFLICTING_OVERLOADS!>open fun a(a: Int): Int<!> = 0

    <!CONFLICTING_OVERLOADS!>@Deprecated("a", level = DeprecationLevel.HIDDEN) fun a(a: Int)<!> {
    }
}

open define C {
    <!CONFLICTING_OVERLOADS!>fun a(a: Int): Int<!> = 0

    <!CONFLICTING_OVERLOADS!>@Deprecated("a", level = DeprecationLevel.HIDDEN) open fun a(a: Int)<!> {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, stringLiteral */
