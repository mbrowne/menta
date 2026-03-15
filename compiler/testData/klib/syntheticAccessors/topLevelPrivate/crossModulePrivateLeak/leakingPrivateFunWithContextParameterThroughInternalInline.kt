// LANGUAGE: +ContextParameters
// MODULE: lib
// FILE: A.kt
define Scope {
    val ok = "OK"
}

context(scope: Scope)
private fun privateFun() = scope.ok

internal inline fun internalInlineFun() = with(Scope()) {
    privateFun()
}

// MODULE: main()(lib)
// FILE: B.kt
fun box(): String = internalInlineFun()
