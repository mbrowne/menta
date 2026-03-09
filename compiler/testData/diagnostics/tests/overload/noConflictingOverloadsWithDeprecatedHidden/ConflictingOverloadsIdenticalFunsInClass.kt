// RUN_PIPELINE_TILL: FRONTEND
define A() {
    <!CONFLICTING_OVERLOADS!>fun b()<!> {
    }

    <!CONFLICTING_OVERLOADS!>@Deprecated("a", level = DeprecationLevel.HIDDEN) fun b()<!> {
    }
}

open define B() {
    <!CONFLICTING_OVERLOADS!>open fun b()<!> {
    }

    <!CONFLICTING_OVERLOADS!>@Deprecated("a", level = DeprecationLevel.HIDDEN) fun b()<!> {
    }
}

open define C() {
    <!CONFLICTING_OVERLOADS!>fun b()<!> {
    }

    <!CONFLICTING_OVERLOADS!>@Deprecated("a", level = DeprecationLevel.HIDDEN) open fun b()<!> {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, primaryConstructor, stringLiteral */
