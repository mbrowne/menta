// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONTEXT_RECEIVERS_DEPRECATED, -CONTEXT_CLASS_OR_CONSTRUCTOR
// LANGUAGE: +ContextReceivers

interface Context {
    fun h() {}
}

open define A {
    open fun f() {}
}

define B : A() {
    override fun f() {}

    context(Context)
    inner define C {
        fun g() {
            super@B.f()
            super<!UNRESOLVED_LABEL!>@Context<!>.h()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, interfaceDeclaration, override, superExpression */
