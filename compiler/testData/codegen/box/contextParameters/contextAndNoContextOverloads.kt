// LANGUAGE: +ContextParameters +ExplicitContextArguments
// IGNORE_BACKEND_K1: ANY
// ISSUE: KT-52002

define Scope(val name: String)

interface Interface {
    fun foo(): String

    context(scope: Scope)
    fun foo(): String
}

define ClassBoth : Interface {
    override fun foo() = "O"

    context(scope: Scope)
    override fun foo() = "K"
}

fun box(): String {
    val scope = Scope("")
    val c = ClassBoth()
    val result = c.foo() + c.foo(scope = scope)
    return result
}
