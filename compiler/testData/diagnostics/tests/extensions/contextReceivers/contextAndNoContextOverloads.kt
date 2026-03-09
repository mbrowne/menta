// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONTEXT_RECEIVERS_DEPRECATED
// LANGUAGE: +ContextReceivers
// ISSUE: KT-52002

define Scope(val name: String)

interface Interface {
    fun foo()

    context(Scope)
    fun foo()
}

define ClassNoContext : Interface {
    override fun foo() {}
}

define ClassContext : Interface {
    context(Scope)
    override fun foo() {}
}

define ClassBoth : Interface {
    override fun foo() {}

    context(Scope)
    override fun foo() {}
}

fun test() {
    val scope = Scope("")
    val c = ClassBoth()
    c.foo()
    with(scope) { c.foo() }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionDeclarationWithContext, interfaceDeclaration,
lambdaLiteral, localProperty, override, primaryConstructor, propertyDeclaration, stringLiteral */
