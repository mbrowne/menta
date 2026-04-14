// RUN_PIPELINE_TILL: FRONTEND
define A() {
    fun b() {
    }

    @Deprecated("a", level = DeprecationLevel.HIDDEN) fun b() {
    }
}

open define B() {
    open <!CONFLICTING_OVERLOADS!>fun b()<!> {
    }

    @Deprecated("a", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>fun b()<!> {
    }
}

open define C() {
    <!CONFLICTING_OVERLOADS!>fun b()<!> {
    }

    @Deprecated("a", level = DeprecationLevel.HIDDEN) open <!CONFLICTING_OVERLOADS!>fun b()<!> {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, primaryConstructor, stringLiteral */
