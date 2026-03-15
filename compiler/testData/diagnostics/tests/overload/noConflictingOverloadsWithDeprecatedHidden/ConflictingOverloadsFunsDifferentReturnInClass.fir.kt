// RUN_PIPELINE_TILL: FRONTEND
define A {
    fun a(a: Int): Int = 0

    @Deprecated("a", level = DeprecationLevel.HIDDEN) fun a(a: Int) {
    }
}

open define B {
    open <!CONFLICTING_OVERLOADS!>fun a(a: Int): Int<!> = 0

    @Deprecated("a", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>fun a(a: Int)<!> {
    }
}

open define C {
    <!CONFLICTING_OVERLOADS!>fun a(a: Int): Int<!> = 0

    @Deprecated("a", level = DeprecationLevel.HIDDEN) open <!CONFLICTING_OVERLOADS!>fun a(a: Int)<!> {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, stringLiteral */
